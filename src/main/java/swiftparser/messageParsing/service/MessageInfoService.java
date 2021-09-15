package swiftparser.messageParsing.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import swiftparser.messageParsing.model.AbstractSwiftMessage;
import swiftparser.messageParsing.payload.GeneralInfoPagination;
import swiftparser.messageParsing.payload.MessageDetailedInfoModel;
import swiftparser.messageParsing.payload.MessageGeneralInfoModel;
import swiftparser.messageParsing.repository.MessagePagingRepository;
import swiftparser.messageParsing.repository.MessageRepository;

@Service
public class MessageInfoService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessagePagingRepository messagePagingRepository;

    // Return Detailed info of Specific Message
    public MessageDetailedInfoModel getMessageDetailInfo(Long id){
        AbstractSwiftMessage abstractSwiftMessage = messageRepository.findById(id).get();
        return new MessageDetailedInfoModel(abstractSwiftMessage.getBlock1(), abstractSwiftMessage.getBlock2()
        , abstractSwiftMessage.getTagBlock());
    }
    
    // Return of existing messages with their genenral information(Message Type, ID, Sender, Receiver)
    public GeneralInfoPagination getDecomposedMessages(Pageable pageable) {
        Page<AbstractSwiftMessage> abstractSwiftMessages = messagePagingRepository.findAll(pageable);
        ArrayList<MessageGeneralInfoModel> messageGeneralInfoModels = new ArrayList<>();
        for (AbstractSwiftMessage abstractSwiftMessage : abstractSwiftMessages) {
            messageGeneralInfoModels.add( new MessageGeneralInfoModel(String.valueOf(abstractSwiftMessage.getMessageId()),
            abstractSwiftMessage.getBlock1().getLogicalTerminal(),
            abstractSwiftMessage.getBlock1().getLogicalTerminal(),
            "MT" + abstractSwiftMessage.getBlock2().getMessageType() ,
            abstractSwiftMessage.getCreatedAt().toString()
            ));
        }
        GeneralInfoPagination generalInfoPagination = new GeneralInfoPagination();
        generalInfoPagination.setMessageGeneralInfoModel(messageGeneralInfoModels);
        generalInfoPagination.setPageNumber(String.valueOf(abstractSwiftMessages.getPageable().getPageNumber()));
        generalInfoPagination.setPageSize(String.valueOf(abstractSwiftMessages.getPageable().getPageSize()));
        generalInfoPagination.setTotalPages(String.valueOf(abstractSwiftMessages.getTotalPages()));
        return generalInfoPagination;
    }
}
