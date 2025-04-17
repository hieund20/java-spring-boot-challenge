package com.example.task_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading để không lấy quá nhiều thông tin
    @JoinColumn(name = "category_id")
    private TaskCategory category;

    public Task(String name, String description, boolean completed) {
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    public Task(String name, String description, boolean completed, TaskCategory taskCategory) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.category = taskCategory;
    }
}
