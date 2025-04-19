package com.example.task_management.service;

import com.example.task_management.dto.TaskDTO;
import com.example.task_management.exception.TaskNotFoundException;
import com.example.task_management.model.*;
import com.example.task_management.repository.TaskRepository;
import com.example.task_management.repository.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    public PaginatedData<TaskDTO> getAllTasks(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Task> taskPage = taskRepository.findAll(pageable);

        List<TaskDTO> taskDTOS = taskPage.getContent().stream().map(task -> new TaskModel(task).toDto()).
                collect(Collectors.toList());

        Pagination pagination = new Pagination(taskPage.getNumber(), taskPage.getTotalPages(), taskPage.getSize());

        return new PaginatedData<>(taskDTOS, pagination);
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        if (taskDTO.getTaskCategoryDTO() == null || taskDTO.getTaskCategoryDTO().getId() == null) {
            throw new IllegalArgumentException("Task CategoryID cannot be null");
        }

        TaskCategory taskCategory = taskCategoryRepository.findById(taskDTO.getTaskCategoryDTO().getId())
                .orElseThrow(() -> new IllegalArgumentException("Task Category not found"));

        Task task = new Task(taskDTO.getName(), taskDTO.getDescription(), false,
                taskCategory);
        taskRepository.save(task);

        return new TaskModel(task).toDto();
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        taskRepository.save(task);

        return new TaskModel(task).toDto();
    }

    public TaskDTO markTaskAsComplete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        task.setCompleted(true);
        taskRepository.save(task);
        return new TaskModel(task).toDto();
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        taskRepository.delete(task);
    }
}
