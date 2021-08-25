package swiftparser.messageParsing.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.repository.MessageRepository;

@Service
public class MessageToJsonService {

    @Autowired
    MessageRepository messageRepository;

    public String convertToJson(Long id) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        AbstractSwiftMessage abstractSwiftMessage = messageRepository.findById(id).get();
        return objectMapper.writeValueAsString(abstractSwiftMessage);
    }
}
