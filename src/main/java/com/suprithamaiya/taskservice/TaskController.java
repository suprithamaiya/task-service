package com.suprithamaiya.taskservice;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Task> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> create(@Valid @RequestBody CreateTaskRequest request) {
        TaskStatus status = request.status() != null ? request.status() : TaskStatus.TODO;
        Task saved = repository.save(new Task(request.title(), status));
        return ResponseEntity.created(URI.create("/tasks/" + saved.getId())).body(saved);
    }
}
