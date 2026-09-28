# task-service

Minimal Spring Boot 3 / Java 21 REST service, the starting point for a portfolio project covering AWS (ECR, ECS Fargate) and Spring AI.

## Stack
Spring Boot 3.5 · Spring Web · Spring Data JPA · H2 (in-memory) · Bean Validation · Maven wrapper

## Run
```bash
./mvnw spring-boot:run
```

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
- [ ] Phase 2: Dockerfile, push image to Amazon ECR
- [ ] Phase 3: Deploy on ECS Fargate
- [ ] Phase 4: Spring AI RAG endpoint backed by Claude
