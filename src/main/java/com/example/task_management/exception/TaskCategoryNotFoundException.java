package com.example.task_management.exception;

public class TaskCategoryNotFoundException extends RuntimeException {
    public TaskCategoryNotFoundException(String message) {
        super(message);
    }

    public TaskCategoryNotFoundException() {
        super("Task Category Not Found");
    }

    public TaskCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskCategoryNotFoundException(Throwable cause) {
        super(cause);
    }
}
