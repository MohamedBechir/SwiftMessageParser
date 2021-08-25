package swiftparser.messageParsing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.service.MessageToJsonService;

@RestController
public class MessageToJsonController {

    @Autowired
    MessageToJsonService messageToJsonService;

    @GetMapping("messages/{id}/toJson")
    public String convertToJson(@PathVariable Integer id) throws JsonProcessingException{
       return messageToJsonService.convertToJson(Long.valueOf(id));
    } 
}
