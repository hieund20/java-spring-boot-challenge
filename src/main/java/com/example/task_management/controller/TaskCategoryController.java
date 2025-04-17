package com.example.task_management.controller;

import com.example.task_management.dto.TaskCategoryDTO;
import com.example.task_management.model.ApiResponse;
import com.example.task_management.service.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-categories")
public class TaskCategoryController {
    @Autowired
    private TaskCategoryService taskCategoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TaskCategoryDTO>>> getAllTaskCategory() {
        List<TaskCategoryDTO> tasks = taskCategoryService.getAllTaskCategories();
        ApiResponse<List<TaskCategoryDTO>> response =
                new ApiResponse<>(200, "Lấy danh sách thành công", tasks, null);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TaskCategoryDTO>> createTaskCategory(
            @RequestBody TaskCategoryDTO taskCategoryDTO) {
        TaskCategoryDTO created = taskCategoryService.createTaskCategory(taskCategoryDTO);
        ApiResponse<TaskCategoryDTO> response =
                new ApiResponse<>(201, "Tạo task thành công", created, null);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskCategoryDTO>> updateTaskCategory(
            @PathVariable Long id, @RequestBody TaskCategoryDTO taskCategoryDTO) {
        TaskCategoryDTO updated = taskCategoryService.updateTaskCategory(id, taskCategoryDTO);
        ApiResponse<TaskCategoryDTO> response =
                new ApiResponse<>(200, "Cập nhật thành công", updated, null);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTask(@PathVariable Long id) {
        taskCategoryService.deleteTaskCategory(id);
        ApiResponse<Void> response =
                new ApiResponse<>(200, "Xóa task thành công", null, null);

        return ResponseEntity.ok(response);
    }
}
