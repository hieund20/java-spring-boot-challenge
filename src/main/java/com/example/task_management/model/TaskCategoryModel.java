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
public class TaskCategoryModel {
    private Long id;
    private String name;

    //Chuyển từ Entity sang model
    public TaskCategoryModel(TaskCategory entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    //Chuyển từ Model sang DTO
    public TaskCategoryDTO toDto() {
        return new TaskCategoryDTO(this.id, this.name);
    }
}
