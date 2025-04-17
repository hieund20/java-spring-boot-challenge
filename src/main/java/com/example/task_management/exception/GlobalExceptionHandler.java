package com.example.task_management.exception;

import com.example.task_management.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleTaskNotFound(TaskNotFoundException ex) {
        ApiResponse<Void> response = new ApiResponse<>(404, ex.getMessage(), null, null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskCategoryNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleTaskCategoryNotFound(TaskCategoryNotFoundException ex) {
        ApiResponse<Void> response = new ApiResponse<>(404, ex.getMessage(), null, null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException (Exception ex) {
        ApiResponse<Void> response = new ApiResponse<>(500, "Lỗi hệ thống", null, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
