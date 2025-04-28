package com.example.task_management.service;

import com.example.task_management.dto.ContractImageDTO;
import com.example.task_management.model.ContractImage;
import com.example.task_management.model.ContractImageModel;
import com.example.task_management.repository.ContractImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContractImageService {
    @Autowired
    private ContractImageRepository contractImageRepository;

    public List<ContractImageDTO> uploadImages(
            String title,
            String description,
            List<MultipartFile> files) {
        List<ContractImageDTO> savedImages = new ArrayList<>();

        String uploadDir = "D:/uploads/";  // Đảm bảo dùng đường dẫn tuyệt đối
        File uploadFolder = new File(uploadDir);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();  // Tạo thư mục nếu chưa tồn tại
        }

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                // Generate unique filename
                String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                File dest = new File(uploadDir + filename);
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                // Lưu thông tin vào database
                ContractImage contractImage = new ContractImage();
                contractImage.setDescription(description);
                contractImage.setUrl("/uploads/" + filename);
                contractImage.setTitle(title);

                ContractImage savedContractImage = contractImageRepository.save(contractImage);

                ContractImageModel model = new ContractImageModel(savedContractImage);

                savedImages.add(model.toDto());
            }
        }
        return savedImages;
    }
}

//curl --location 'http://localhost:8080/contract-images/upload' \
//        --form 'files=@"/C:/Users/hieund/Downloads/Group 55.png"' \
//        --form 'title="hieu"' \
//        --form 'description="hieu"'