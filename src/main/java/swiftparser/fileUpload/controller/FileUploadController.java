package swiftparser.fileUpload.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import swiftparser.fileUpload.service.FileUploadService;
import swiftparser.fileUpload.payload.UploadFileResponse;


@RestController
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/files")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file){
        String fileName = fileUploadService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        
        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

}
