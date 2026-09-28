package com.suprithamaiya.taskservice;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskRequest(@NotBlank String title, TaskStatus status) {
}
