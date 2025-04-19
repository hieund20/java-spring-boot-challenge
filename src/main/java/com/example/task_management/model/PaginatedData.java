package com.example.task_management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PaginatedData<T>{
    private List<T> content;
    private Pagination pagination;

    public PaginatedData(List<T> content, Pagination pagination) {
        this.content = content;
        this.pagination = pagination;
    }
}
