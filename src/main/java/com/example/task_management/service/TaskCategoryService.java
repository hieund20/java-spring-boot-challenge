package com.example.task_management.service;

import com.example.task_management.dto.TaskCategoryDTO;
import com.example.task_management.dto.TaskDTO;
import com.example.task_management.exception.TaskCategoryNotFoundException;
import com.example.task_management.exception.TaskNotFoundException;
import com.example.task_management.model.Task;
import com.example.task_management.model.TaskCategory;
import com.example.task_management.model.TaskCategoryModel;
import com.example.task_management.model.TaskModel;
import com.example.task_management.repository.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskCategoryService {
    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    public List<TaskCategoryDTO> getAllTaskCategories() {
        List<TaskCategory> taskCategories = taskCategoryRepository.findAll();
        return taskCategories.stream().map(taskCategory ->
                new TaskCategoryModel(taskCategory).toDto()).collect(Collectors.toList());
    }

    public TaskCategoryDTO createTaskCategory(TaskCategoryDTO taskCategoryDTO) {
        TaskCategory taskCategory = new TaskCategory(taskCategoryDTO.getName());
        taskCategoryRepository.save(taskCategory);

        return new TaskCategoryModel(taskCategory).toDto();
    }

    public TaskCategoryDTO updateTaskCategory(Long id, TaskCategoryDTO taskCategoryDTO) {
        TaskCategory taskCategory = taskCategoryRepository.findById(id)
                .orElseThrow(() -> new TaskCategoryNotFoundException("Task Category not found"));

        taskCategory.setName(taskCategoryDTO.getName());
        taskCategoryRepository.save(taskCategory);

        return new TaskCategoryModel(taskCategory).toDto();
    }

    public void deleteTaskCategory(Long id) {
        TaskCategory taskCategory = taskCategoryRepository.findById(id)
                .orElseThrow(() -> new TaskCategoryNotFoundException("Task Category not found"));
        taskCategoryRepository.delete(taskCategory);
    }
}
