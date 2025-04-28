package com.example.task_management.repository;

import com.example.task_management.model.ContractImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractImageRepository extends JpaRepository<ContractImage, Long> {
}
