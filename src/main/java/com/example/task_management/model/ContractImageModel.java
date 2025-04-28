package com.example.task_management.model;

import com.example.task_management.dto.ContractImageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractImageModel {
    private Long id;

    private String title;

    private String description;

    private String url;

    //Chuyển từ Entity sang model
    public ContractImageModel(ContractImage entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.url = entity.getUrl();
    }

    //Chuyển từ Model sang DTO
    public ContractImageDTO toDto() {
        return new ContractImageDTO(
                this.id,
                this.title,
                this.description,
                this.url);
    }
}
