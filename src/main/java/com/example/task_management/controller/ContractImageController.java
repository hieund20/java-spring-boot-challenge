package com.example.task_management.controller;

import com.example.task_management.dto.ContractImageDTO;
import com.example.task_management.model.ApiResponse;
import com.example.task_management.service.ContractImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/contract-images")
public class ContractImageController {
    @Autowired
    private ContractImageService contractImageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<List<ContractImageDTO>>> uploadImages(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("files") List<MultipartFile> files) {

        List<ContractImageDTO> savedImages = contractImageService.uploadImages(title, description, files);

        ApiResponse<List<ContractImageDTO>> response =
                new ApiResponse<>(200, "Upload thành công", savedImages, null);

        return ResponseEntity.ok(response);
    }
}
