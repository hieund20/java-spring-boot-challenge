package com.example.task_management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pagination {
    private int currentPage;
    private int totalPage;
    private int pageSize;

    public Pagination(int number, int totalPages, int size) {
        this.currentPage = number;
        this.totalPage = totalPages;
        this.pageSize = size;
    }
}
