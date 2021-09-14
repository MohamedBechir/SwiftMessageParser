package swiftparser.messageParsing.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Store the Message from a file
    @PostMapping("messages")
    public AbstractSwiftMessage storeMessage(@RequestParam("file") MultipartFile file) throws IOException{
        return messageStorageService.saveMessage(file);
    }

    // Get a specific whole message as a String
    @GetMapping("messages/{id}")
    public String decomposeMessage(@PathVariable String id) throws IOException {
        return messageStorageService.readMessage(Long.valueOf(id)).replace("\n", " ");
    }

    // Delete a specific message[WIP]
    @DeleteMapping("messages")
    public String deleteMessage(@RequestParam("id") Integer id){
        messageStorageService.deleteMessage(Long.valueOf(id));
        return "success";
    }
}