package swiftparser.messageParsing.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.repository.MessageRepository;

@Service
public class MessageToXmlService {

    @Autowired
    MessageRepository messageRepository;

    public String convertMessageToXml(Long id) throws JsonProcessingException{
        XmlMapper xmlMapper = new XmlMapper();
        AbstractSwiftMessage abstractSwiftMessage = messageRepository.findById(id).get();
        return xmlMapper.writeValueAsString(abstractSwiftMessage);
    }

    public String convertMessagesToXml() throws JsonProcessingException{
    XmlMapper xmlMapper = new XmlMapper();
    List<AbstractSwiftMessage> abstractSwiftMessage = messageRepository.findAll();
    List<String> jsonArray = new ArrayList<>();
    for (AbstractSwiftMessage aSwiftMessage : abstractSwiftMessage) {
        jsonArray.add(xmlMapper.writeValueAsString(aSwiftMessage));
    }
    return jsonArray.toString();
}
}
