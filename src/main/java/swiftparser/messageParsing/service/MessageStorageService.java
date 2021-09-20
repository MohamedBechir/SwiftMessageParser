package swiftparser.messageParsing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.ArrayUtils;

import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.repository.MessageRepository;

@Service
public class MessageStorageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    MessageParsingService messageParsingService;

    public AbstractSwiftMessage saveMessage(MultipartFile file ) throws IOException{
       AbstractSwiftMessage abstractSwiftMessage = new AbstractSwiftMessage(
            "Bechir Jamoussi",
            Date.from(Instant.now()),
            Date.from(Instant.now()),
            "Bechir Jamoussi",
            Date.from(Instant.now()),
            file.getSize()
        );
       /*  String filename = file.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf(".") + 1); */
        abstractSwiftMessage.setMessageBody(ArrayUtils.toObject(file.getBytes()));
        AbstractSwiftMessage abstractSwiftMessageResponse =  messageRepository.save(abstractSwiftMessage);
        messageParsingService.decomposeMessage(abstractSwiftMessageResponse.getMessageId());
        return abstractSwiftMessageResponse;
    } 

    @Transactional
    public String readMessage(Long id) throws IOException {

        AbstractSwiftMessage abstractSwiftMessage = messageRepository.getById(id);
        byte[] bytes = new byte[Integer.valueOf(abstractSwiftMessage.getFileSize().intValue())];

        int i=0;
        for(Byte b: abstractSwiftMessage.getMessageBody())
            bytes[i++] = b.byteValue();
        return new String(bytes);
     }

     @Transactional
     public String deleteMessage(Long id){
         List<Long> list = new ArrayList<>();
         list.add(id);
         messageRepository.deleteAllByIdInBatch(list);
         return "Success";
     }
}
