package swiftparser.messageParsing.service;

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

    public String convertToXml(Long id) throws JsonProcessingException{
        XmlMapper xmlMapper = new XmlMapper();
        AbstractSwiftMessage abstractSwiftMessage = messageRepository.findById(id).get();
        return xmlMapper.writeValueAsString(abstractSwiftMessage);
    }
}
