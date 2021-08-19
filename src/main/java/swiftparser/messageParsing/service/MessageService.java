package swiftparser.messageParsing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.AbstractMT;

import org.apache.commons.lang3.ArrayUtils;


import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.model.Block1;
import swiftparser.messageParsing.model.Block2;
import swiftparser.messageParsing.repository.MessageRepository;
import swiftparser.messageParsing.repository.ParsingRepository; 

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ParsingRepository parsingRepository;

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

    public String extractMessage(Long id) throws IOException {

        AbstractSwiftMessage abstractSwiftMessage = messageRepository.findById(id).get();
        byte[] bytes = new byte[Integer.valueOf(abstractSwiftMessage.getFileSize().intValue())];

        int i=0;
        for(Byte b: abstractSwiftMessage.getMessageBody())
            bytes[i++] = b.byteValue();
        String message = new String(bytes);

        AbstractMT msg = AbstractMT.parse(message);
        
        /*
        Swift Block 1
        */
        Block1 block1 = new Block1();
        SwiftMessage swiftMessage = msg.getSwiftMessage();

        SwiftBlock1 swiftBlock1 = swiftMessage.getBlock1();

        block1.setApplicationId(swiftBlock1.getApplicationId());
        block1.setLogicalTerminal(swiftBlock1.getLogicalTerminal());
        block1.setServiceId(swiftBlock1.getServiceId());
        block1.setSessionNumber(swiftBlock1.getSessionNumber());
        block1.setSequenceNumber(swiftBlock1.getSequenceNumber());
        block1.setId(swiftBlock1.getNumber());
        /*
        Swift Block 2
        */
        Block2 block2 = new Block2();
        SwiftBlock2 swiftBlock2 = swiftMessage.getBlock2();
        block2.setMessagePriority(swiftBlock2.getMessagePriority());
        block2.setMessageType(swiftBlock2.getMessageType());
        block2.setId(block2.getNumber());

        /*
        Save Entities
        */
        parsingRepository.save(block1);
        parsingRepository.save(block2);

        return "hh";
     } 

}
