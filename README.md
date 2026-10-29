# Student API — Bexultan Aralbayev
Spring Boot CRUD application using PostgreSQL, Gradle, Docker Compose and Jenkins.

## Endpoints
- POST /api/students — create
- GET /api/students — list
- GET /api/students/{id} — find
- PUT /api/students/{id} — update
- DELETE /api/students/{id} — delete
- Missing IDs return HTTP 404.

## Start
`docker compose up --build -d`

## Example
`curl -X POST http://localhost:8080/api/students -H 'Content-Type: application/json' -d '{"name":"Bexultan","surname":"Aralbayev","email":"student@example.com"}'`

Local database password in Compose is a development-only default. For shared environments set DB_PASSWORD externally.

## CRUD API - Bexultan Aralbayev

The Spring Boot application supports:
- POST /api/students - create student
- GET /api/students - list students
- GET /api/students/{id} - find student
- PUT /api/students/{id} - update student
- DELETE /api/students/{id} - delete student

Database: PostgreSQL 16
Java: 21
Docker Compose: application and database services
