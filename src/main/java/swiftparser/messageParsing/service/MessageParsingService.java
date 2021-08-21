package swiftparser.messageParsing.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.mt.AbstractMT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swiftparser.messageParsing.model.AbstractBlockField;
import swiftparser.messageParsing.model.Block1;
import swiftparser.messageParsing.model.Block2;
import swiftparser.messageParsing.model.TagBlock;
import swiftparser.messageParsing.repository.BlockRepository;

@Service
public class MessageParsingService {

    @Autowired
    private MessageStorageService messageStorageService;

    @Autowired
    private BlockRepository blockRepository;

    public String decomposeMessage(Long id) throws IOException {
        
        String message = messageStorageService.readMessage(id);
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

        blockRepository.save(block1);
        blockRepository.save(block2);

        /*
        Swift Tag Block(Blocks 3, 4, 5)
        */

        TagBlock tagBlock = new TagBlock();
        SwiftBlock3 swiftBlock3 = swiftMessage.getBlock3();
        SwiftBlock4 swiftBlock4 = swiftMessage.getBlock4();
        SwiftBlock5 swiftBlock5 = swiftMessage.getBlock5();


        if (swiftBlock3 != null) {
            List<AbstractBlockField> list3 = new ArrayList<AbstractBlockField>();


            for (Tag tag : swiftBlock3.getTags()) {
                AbstractBlockField abstractBlockField = new AbstractBlockField();
                abstractBlockField.setTagName(tag.getName());
                abstractBlockField.setTagValue(tag.getValue());
                list3.add(abstractBlockField);
            }
    
            Set<AbstractBlockField> set3 = new HashSet<AbstractBlockField>(list3);
            set3.addAll(list3);
            tagBlock.setId(3);
            tagBlock.setFields(set3);  
            blockRepository.save(tagBlock); 
        }

        if (swiftBlock4 != null) {
            List<AbstractBlockField> list4 = new ArrayList<AbstractBlockField>();


        for (Tag tag : swiftBlock4.getTags()) {
            AbstractBlockField abstractBlockField = new AbstractBlockField();
            abstractBlockField.setTagName(tag.getName());
            abstractBlockField.setTagValue(tag.getValue());
            list4.add(abstractBlockField);
        }

        Set<AbstractBlockField> set4 = new HashSet<AbstractBlockField>(list4);
        set4.addAll(list4);
        tagBlock.setId(4);
        tagBlock.setFields(set4);       
        blockRepository.save(tagBlock);     
        }


        if (swiftBlock5 != null) {
            List<AbstractBlockField> list5 = new ArrayList<AbstractBlockField>();


            for (Tag tag : swiftBlock5.getTags()) {
                AbstractBlockField abstractBlockField = new AbstractBlockField();
                abstractBlockField.setTagName(tag.getName());
                abstractBlockField.setTagValue(tag.getValue());
                list5.add(abstractBlockField);
            }

            Set<AbstractBlockField> set5 = new HashSet<AbstractBlockField>(list5);
            set5.addAll(list5);
            tagBlock.setId(5);
            tagBlock.setFields(set5);   
            blockRepository.save(tagBlock);
        }

        return "Success";
    }
}
