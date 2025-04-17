package com.example.task_management.model;

import com.example.task_management.dto.TaskCategoryDTO;
import com.example.task_management.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {
    private Long id;
    private String name;
    private String description;
    private boolean completed;
    private TaskCategoryDTO taskCategory;

    //Chuyển từ Entity sang Model
    public TaskModel(Task entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.completed = entity.isCompleted();
        this.taskCategory = new TaskCategoryDTO(entity.getCategory().getId(), entity.getCategory().getName());
    }

    //Chuyển từ Model sang DTO
    public TaskDTO toDto() {
        return new TaskDTO(this.id, this.name, this.description, this.completed, this.taskCategory);
    }
}
