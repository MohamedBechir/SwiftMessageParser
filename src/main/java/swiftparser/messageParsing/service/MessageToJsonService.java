package swiftparser.messageParsing.service;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.payload.MessageDetailedInfoModel;
import swiftparser.messageParsing.repository.MessageRepository;

@Service
public class MessageToJsonService {

    @Autowired
    MessageRepository messageRepository;

    public String convertMessageToJson(Long id) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        AbstractSwiftMessage abstractSwiftMessage = messageRepository.findById(id).get();
        AbstractSwiftMessage aMessage = new AbstractSwiftMessage();
        aMessage.setSentOn(Date.from(Instant.now()));
        aMessage.setSentJson(true);
        messageRepository.save(aMessage);
        return objectMapper.writeValueAsString(abstractSwiftMessage);
    }

    public List<MessageDetailedInfoModel> convertMessagesToJson() throws JsonProcessingException{
        List<AbstractSwiftMessage> abstractSwiftMessage = messageRepository.findAll();
        List<MessageDetailedInfoModel> jsonArray = new ArrayList<>();
        for (AbstractSwiftMessage aSwiftMessage : abstractSwiftMessage) {
            jsonArray.add(new MessageDetailedInfoModel(aSwiftMessage.getBlock1(), aSwiftMessage.getBlock2()
            , aSwiftMessage.getTagBlock(), String.valueOf(aSwiftMessage.getMessageId())));
        }
        return jsonArray;
    }


}
