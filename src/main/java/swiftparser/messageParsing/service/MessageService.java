package swiftparser.messageParsing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.mt.AbstractMT;

import org.apache.commons.lang3.ArrayUtils;

import swiftparser.messageParsing.model.AbstractBlockField;
import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.model.Block1;
import swiftparser.messageParsing.model.Block2;
import swiftparser.messageParsing.model.TagBlock;
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
        SwiftMessage swiftMessage = msg.getSwiftMessage();
        
        /*
        Swift Block 1
        */
        Block1 block1 = new Block1();

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
        Swift Tag Block
        */

        TagBlock tagBlock = new TagBlock();
        // SwiftBlock3 swiftBlock3 = swiftMessage.getBlock3();
        SwiftBlock4 swiftBlock4 = swiftMessage.getBlock4();
        // SwiftBlock5 swiftBlock5 = swiftMessage.getBlock5();

        List<AbstractBlockField> list = new ArrayList<AbstractBlockField>();


        for (Tag tag : swiftBlock4.getTags()) {
            AbstractBlockField abstractBlockField = new AbstractBlockField();
            abstractBlockField.setTagName(tag.getName());
            abstractBlockField.setTagValue(tag.getValue());
            list.add(abstractBlockField);
        }

        Set<AbstractBlockField> set = new HashSet<AbstractBlockField>(list);
        set.addAll(list);
        tagBlock.setId(4);
        tagBlock.setFields(set);

        /*
        Save Entities
        */
        parsingRepository.save(block1);
        parsingRepository.save(block2);
        parsingRepository.save(tagBlock);

        return "hh";
     } 

}
