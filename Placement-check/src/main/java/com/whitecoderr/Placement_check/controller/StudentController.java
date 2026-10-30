package com.whitecoderr.Placement_check.controller;

import com.whitecoderr.Placement_check.dto.StudentDTO;
import com.whitecoderr.Placement_check.dto.StudentLoginRequest;
import com.whitecoderr.Placement_check.model.Student;
import com.whitecoderr.Placement_check.repository.StudentRepository;
import com.whitecoderr.Placement_check.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Student")
public class StudentController {

    private final StudentService service;
    private final StudentRepository studentRepository;

    public StudentController(StudentService service, StudentRepository studentRepository) {
        this.service = service;
        this.studentRepository = studentRepository;
    }


    @GetMapping("/StudentSelect")
    public List<StudentDTO> getAllStudents() {
        return service.getAllStudents().stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    /** Current student's profile (matched by JWT/session email). */
    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        if (authentication == null || authentication.getName() == null) {
            return ResponseEntity.status(401).body(Map.of("message", "Unauthorized"));
        }
        Student student = studentRepository.findByEmailIgnoreCase(authentication.getName());
        if (student == null) {
            return ResponseEntity.status(404).body(Map.of("message", "Student profile not found"));
        }
        return ResponseEntity.ok(new StudentDTO(student));
    }

    @PostMapping("/StudentInsert")
    public StudentDTO studentAdd(@RequestBody Student student) {
        return new StudentDTO(service.saveStudent(student));
    }

    /** Bulk insert — same pattern as /application/addAll */
    @PostMapping("/addAll")
    public List<StudentDTO> addAll(@RequestBody List<Student> students) {
        return service.saveAllStudents(students).stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @PatchMapping("/StudentUpdate/{enrollNo}")
    public StudentDTO updateStudent(@PathVariable String enrollNo, @RequestBody Student student) {
        return new StudentDTO(service.updateStudent(student, enrollNo));
    }

    @DeleteMapping("/StudentDelete/{enrollNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String enrollNo) {
        service.deleteStudent(enrollNo);
        return ResponseEntity.noContent().build();
    }

    /** Student login by email + password. */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody StudentLoginRequest request) {
        if (request.getEmail() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email and password are required"));
        }
        Student student = service.authenticate(request.getEmail(), request.getPassword());
        if (student == null) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password"));
        }
        return ResponseEntity.ok(new StudentDTO(student))   ;
    }

    @GetMapping("/by-email")
    public ResponseEntity<StudentDTO> getByEmail(@RequestParam String email, Authentication auth) {
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin && !auth.getName().equalsIgnoreCase(email)) {
            return ResponseEntity.status(403).build();
        }
        Student student = studentRepository.findByEmailIgnoreCase(email);
        if (student == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new StudentDTO(student));
    }
    //    @GetMapping("/by-email")
//    public ResponseEntity<StudentDTO> getByEmail(@RequestParam String email) {
//        Student student = studentRepository.findByEmailIgnoreCase(email);
//        if (student == null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(new StudentDTO(student));
//    }
}