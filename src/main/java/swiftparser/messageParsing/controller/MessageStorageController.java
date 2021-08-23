package swiftparser.messageParsing.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.service.MessageStorageService;



@RestController
public class MessageStorageController {

    @Autowired
    MessageStorageService messageStorageService;

    @PostMapping("messages")
    public AbstractSwiftMessage storeMessage(@RequestParam("file") MultipartFile file) throws IOException{
        return messageStorageService.saveMessage(file);
    }

    @GetMapping("messages")
    public String readMessage(@RequestParam("id") Integer id) throws IOException{
        return  messageStorageService.readMessage(Long.valueOf(id));
    }

    @DeleteMapping("messages")
    public String deleteMessage(@RequestParam("id") Integer id){
        messageStorageService.deleteMessage(Long.valueOf(id));
        return "success";
    }
}