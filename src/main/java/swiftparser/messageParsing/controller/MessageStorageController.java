package swiftparser.messageParsing.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.service.MessageService;



@RestController
public class MessageStorageController {

    @Autowired
    MessageService messageStorageService;

    @PostMapping("messages")
    public AbstractSwiftMessage storeMessage(@RequestParam("file") MultipartFile file) throws IOException{
        return messageStorageService.saveMessage(file);
    }

    @GetMapping("messages")
    public String readMessage(@RequestParam("id") Integer id) throws IOException{
        messageStorageService.extractMessage(Long.valueOf(id));
        return "messageStorageService.extractMessage(Long.valueOf(id))";
    }

}