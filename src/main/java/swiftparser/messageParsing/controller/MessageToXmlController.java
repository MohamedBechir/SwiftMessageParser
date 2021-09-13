package swiftparser.messageParsing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.service.MessageToXmlService;

@RestController
public class MessageToXmlController {

    @Autowired
    MessageToXmlService messageToXmlService;

    @GetMapping("messages/{id}/toXml")
    public String convertToXml(@PathVariable Integer id) throws JsonProcessingException {
       return messageToXmlService.convertToXml(Long.valueOf(id));
    } 
}
