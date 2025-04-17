package com.example.task_management.controller;

import com.example.task_management.dto.TaskDTO;
import com.example.task_management.model.ApiResponse;
import com.example.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TaskDTO>>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        ApiResponse<List<TaskDTO>> response =
                new ApiResponse<>(200, "Lấy danh sách thành công", tasks, null);


        return ResponseEntity.ok(response);
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
