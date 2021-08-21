package swiftparser.messageParsing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;

import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.repository.MessageRepository;

@Service
public class MessageStorageService {

    @Autowired
    private MessageRepository messageRepository;

    public AbstractSwiftMessage saveMessage(MultipartFile file ) throws IOException{
       AbstractSwiftMessage abstractSwiftMessage = new AbstractSwiftMessage(
            "Bechir Jamoussi",
            Date.from(Instant.now()),
            "Bechir Jamoussi",
            Date.from(Instant.now()),
            file.getSize()
        );
        abstractSwiftMessage.setMessageBody(ArrayUtils.toObject(file.getBytes()));
        AbstractSwiftMessage abstractSwiftMessageResponse =  messageRepository.save(abstractSwiftMessage);
        return abstractSwiftMessageResponse;
    } 

    public String readMessage(Long id) throws IOException {

        AbstractSwiftMessage abstractSwiftMessage = messageRepository.findById(id).get();
        byte[] bytes = new byte[Integer.valueOf(abstractSwiftMessage.getFileSize().intValue())];

        int i=0;
        for(Byte b: abstractSwiftMessage.getMessageBody())
            bytes[i++] = b.byteValue();
        String message = new String(bytes);

        return message;
     } 

     public void deleteMessage(Long id){
        messageRepository.deleteById(id);
     }

}
