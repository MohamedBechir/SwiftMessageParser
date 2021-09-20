package swiftparser.messageParsing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.payload.GeneralInfoPagination;
import swiftparser.messageParsing.payload.MessageDetailedInfoModel;
import swiftparser.messageParsing.service.MessageParsingService;
import swiftparser.messageParsing.service.MessageInfoService;

@RestController
public class MessageParsingController {
    
    @Autowired
    MessageParsingService messageParsingService;

    @Autowired
    MessageInfoService messageInfoService;

    // Get Message Detail Info
    @GetMapping("/messages/decomposedMessages/{id}")
    public MessageDetailedInfoModel decomposedMessage(@PathVariable String id) {
        return messageInfoService.getMessageDetailInfo(Long.valueOf(id));
    }

    // For the table of SWIFT Messages
    @GetMapping("/messages/decomposedMessage/{messageType}")
    public GeneralInfoPagination getDecomposedMessagesPerType(@PathVariable(required = false) String messageType) {
        return messageInfoService.getDecomposedMessagesPerType(messageType);
    }

    @GetMapping("/messages/decomposedMessage")
    public GeneralInfoPagination getDecomposedMessages(Pageable pageable) {
        return messageInfoService.getDecomposedMessages(pageable);
    }
}
