package swiftparser.messageParsing.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.payload.MessageDetailedInfoModel;
import swiftparser.messageParsing.repository.MessageRepository;
import swiftparser.messageParsing.service.MessageToJsonService;

@RestController
@EnableJms
public class MessageToJsonController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageToJsonService messageToJsonService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages/send/{id}/toJson")
    public Object sendJSONToQueue(@PathVariable Integer id) throws JsonProcessingException{
        try{
            String Json = messageToJsonService.convertMessageToJson(Long.valueOf(id));
            jmsTemplate.convertAndSend("DEV.QUEUE.2", Json);
            return  Json;
        }catch(JmsException ex){
            ex.printStackTrace();
            return "FAIL";
        }
    }

    @GetMapping("/messages/tojson")
    public List<MessageDetailedInfoModel> convertMessagesToJson() throws JsonProcessingException{
        List<MessageDetailedInfoModel> JsonArray=null;
        try{
           JsonArray = messageToJsonService.convertMessagesToJson();
        }catch(JmsException ex){
            ex.printStackTrace();
        }
        return JsonArray;
    }

    @GetMapping("messages/receive")
    Object ReceiveJSONFromQueue(){
    try{
        return jmsTemplate.receiveAndConvert("DEV.QUEUE.2");
    }catch(JmsException ex){
        ex.printStackTrace();
        return "FAIL";
    }
}
}