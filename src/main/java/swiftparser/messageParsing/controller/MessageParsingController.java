package swiftparser.messageParsing.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.service.MessageParsingService;

@RestController
public class MessageParsingController {
    
    @Autowired
    MessageParsingService messageParsingService;

    @PostMapping("/messages/decompose")
    public String decomposeMessage(@RequestParam("id") Integer id) throws IOException {
        messageParsingService.decomposeMessage(Long.valueOf(id));
        return "Success";
    }
}
