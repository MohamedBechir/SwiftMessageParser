package swiftparser.messageParsing.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.payload.MessageInfoModel;
import swiftparser.messageParsing.service.MessageParsingService;
import swiftparser.messageParsing.service.MessageInfoService;

@RestController
public class MessageParsingController {
    
    @Autowired
    MessageParsingService messageParsingService;

    @Autowired
    MessageInfoService messageInfoService;

    @PostMapping("/messages/decomposedMessage")
    public String decomposeMessage(@RequestParam("id") Integer id) throws IOException {
        messageParsingService.decomposeMessage(Long.valueOf(id));
        return "Success";
    }

    @GetMapping("/messages/decomposedMessage")
    public MessageInfoModel decomposedMessage(@RequestParam("id") Integer id) {
        return messageInfoService.getMessageInfo(Long.valueOf(id));
    }

    @GetMapping("messages/decomposedMessages")
    public List<MessageInfoModel> getDecomposedMessages() {
         return messageInfoService.getDecomposedMessages();
    }
}
