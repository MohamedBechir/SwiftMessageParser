package swiftparser.messageParsing.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.payload.MessageDetailedInfoModel;
import swiftparser.messageParsing.payload.MessageGeneralInfoModel;
import swiftparser.messageParsing.service.MessageParsingService;
import swiftparser.messageParsing.service.MessageInfoService;

@RestController
public class MessageParsingController {
    
    @Autowired
    MessageParsingService messageParsingService;

    @Autowired
    MessageInfoService messageInfoService;

    // Decompose the message into Blocks and Store them
    @PostMapping("/messages/decomposedMessage")
    public String decomposeMessage(@RequestParam("id") Integer id) throws IOException {
        messageParsingService.decomposeMessage(Long.valueOf(id));
        return "Success";
    }

    // For Specific Message Information
    @GetMapping("/messages/decomposedMessage")
    public MessageDetailedInfoModel decomposedMessage(@RequestParam("id") Integer id) {
        return messageInfoService.getMessageInfo(Long.valueOf(id));
    }

    // For the table of SWIFT Messages
    @GetMapping("messages/decomposedMessages")
    public List<MessageGeneralInfoModel> getDecomposedMessages() {
         return messageInfoService.getDecomposedMessages();
    }
}
