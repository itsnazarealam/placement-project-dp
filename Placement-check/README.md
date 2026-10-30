# Placement-check (Backend)

Spring Boot 3.3 REST API for the College Placement Cell Management System, with JWT authentication.

## Run

```bash
mvn spring-boot:run
```

Server: **http://localhost:8080**

Configure MySQL in `src/main/resources/application.properties`. JWT settings:

- `jwt.secret` — HS256 signing key (keep private in production)
- `jwt.expiration-ms` — token lifetime (default 24h)

## Public vs protected

| Endpoint | Access |
|----------|--------|
| `POST /user/register`, `POST /user/login`, `PUT /user/reset-password` | Public |
| `GET /api/companies` | Public (approved only) |
| `GET /user/me` | Authenticated |
| `GET /api/companies/all`, approve, delete | `ADMIN` |
| `GET /Student/StudentSelect`, `POST /Student/addAll`, student CRUD | `ADMIN` |
| `GET /Student/me` | `STUDENT` / `ADMIN` |
| Everything else | Authenticated |

Login response:

```json
{ "token": "<jwt>", "role": "STUDENT", "username": "...", "userId": 1, "userMail": "..." }
```

Send `Authorization: Bearer <token>` on protected requests.

Pair with the frontend at `../placement-cell-ui` (`npm run dev` on port 5173).
