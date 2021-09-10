package swiftparser.messageParsing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.payload.MessageInfoModel;
import swiftparser.messageParsing.repository.MessageRepository;

@Service
public class MessageInfoService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageInfoModel getMessageInfo(Long id){
        AbstractSwiftMessage abstractSwiftMessage = messageRepository.findById(id).get();
        MessageInfoModel messageInfoModel = new MessageInfoModel();
        
        messageInfoModel.setId(String.valueOf(id));
        messageInfoModel.setSenderBIC(abstractSwiftMessage.getBlock1().getLogicalTerminal());
        messageInfoModel.setReceiverBIC(abstractSwiftMessage.getBlock1().getLogicalTerminal());
        messageInfoModel.setMessageType("MT" + abstractSwiftMessage.getBlock2().getMessageType());
        messageInfoModel.setCreatedAt(abstractSwiftMessage.getCreatedAt().toString());
        return messageInfoModel;
    }

    public  List<MessageInfoModel> getDecomposedMessages() {
        List<AbstractSwiftMessage> abstractSwiftMessages = messageRepository.findAll();
        List<MessageInfoModel> messageInfoModels = new ArrayList<>();

        for (AbstractSwiftMessage abstractSwiftMessage : abstractSwiftMessages) {
            messageInfoModels.add( new MessageInfoModel(String.valueOf(abstractSwiftMessage.getMessageId()),
            abstractSwiftMessage.getBlock1().getLogicalTerminal(),
            abstractSwiftMessage.getBlock1().getLogicalTerminal(),
            "MT" + abstractSwiftMessage.getBlock2().getMessageType() ,
            abstractSwiftMessage.getCreatedAt().toString() ));
        }
        return messageInfoModels;
    }
}
