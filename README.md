# task-service

Minimal Spring Boot 3 / Java 21 REST service, the starting point for a portfolio project covering AWS (ECR, ECS Fargate) and Spring AI.

## Stack
Spring Boot 3.5 · Spring Web · Spring Data JPA · H2 (in-memory) · Bean Validation · Actuator · Maven wrapper · Docker

## Run
```bash
./mvnw spring-boot:run
```

### With Docker
```bash
docker build -t task-service:0.0.1 .
docker run --rm -p 8080:8080 task-service:0.0.1
```
Multi-stage build (JDK build stage, JRE runtime), runs as a non-root user. Health check: `GET /actuator/health` (liveness/readiness probes enabled).

## API
| Method | Path     | Description |
|--------|----------|-------------|
| GET    | `/tasks` | List all tasks |
| POST   | `/tasks` | Create a task: `{"title": "...", "status": "TODO\|IN_PROGRESS\|DONE"}` (status optional, defaults to `TODO`). Returns `201` + `Location`. Blank title → `400`. |

```bash
curl -X POST localhost:8080/tasks -H 'Content-Type: application/json' -d '{"title":"Learn ECS Fargate"}'
curl localhost:8080/tasks
```

## Roadmap
- [x] Phase 1: REST service with JPA + H2
- [x] Phase 2a: Actuator health checks + multi-stage Dockerfile
- [ ] Phase 2b: Push image to Amazon ECR
- [ ] Phase 3: Deploy on ECS Fargate
- [ ] Phase 4: Spring AI RAG endpoint backed by Claude
