package com.example.task_management.service;

import com.example.task_management.dto.TaskDTO;
import com.example.task_management.exception.TaskNotFoundException;
import com.example.task_management.model.Task;
import com.example.task_management.model.TaskModel;
import com.example.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(task -> new TaskModel(task).toDto()).collect(Collectors.toList());
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getName(), taskDTO.getDescription(), false);
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
