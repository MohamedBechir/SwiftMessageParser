package swiftparser.messageParsing.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.payload.MessageSending;
import swiftparser.messageParsing.payload.XMLMessageReponse;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.JmsException;


import swiftparser.messageParsing.service.MessageToXmlService;

@RestController
@EnableJms
public class MessageToXmlController {

    @Autowired
    MessageToXmlService messageToXmlService;
    
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages/xml/send/{id}")
    public MessageSending sendXMLToQueue(@PathVariable Integer id) throws JmsException, JsonProcessingException{
       String Json = messageToXmlService.convertMessageToXml(Long.valueOf(id));
       jmsTemplate.convertAndSend("DEV.QUEUE.2", Json);
       return  new MessageSending("Message successfully sent to queue") ;
    }

    @GetMapping("/messages/{id}/toxml")
    public String convertMessageToXml(@PathVariable Integer id) throws JsonProcessingException {
       return messageToXmlService.convertMessageToXml(Long.valueOf(id));
    }

    @GetMapping("/messages/toxml")
    public List<XMLMessageReponse> convertMessagesToXml() throws JsonProcessingException {
       return messageToXmlService.convertMessagesToXml();
    } 
}
