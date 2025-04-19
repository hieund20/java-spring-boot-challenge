package com.example.task_management.controller;

import com.example.task_management.dto.TaskDTO;
import com.example.task_management.model.ApiResponse;
import com.example.task_management.model.PaginatedData;
import com.example.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ApiResponse<PaginatedData<TaskDTO>> getAllTasks(
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam(defaultValue = "5") int pageSize) {
        PaginatedData<TaskDTO> result = taskService.getAllTasks(currentPage, pageSize);

        return new ApiResponse<>(200, "Lấy danh sách thành công", result, null);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TaskDTO>> createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO created = taskService.createTask(taskDTO);
        ApiResponse<TaskDTO> response =
                new ApiResponse<>(201, "Tạo task thành công", created, null);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskDTO>> markTasksComplete(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updated = taskService.updateTask(id, taskDTO);
        ApiResponse<TaskDTO> response =
                new ApiResponse<>(200, "Cập nhật thành công", updated, null);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        ApiResponse<Void> response =
                new ApiResponse<>(200, "Xóa task thành công", null, null);

        return ResponseEntity.ok(response);
    }
}
