package swiftparser.messageParsing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import swiftparser.messageParsing.payload.MessagesPerTypeStats;
import swiftparser.messageParsing.service.MessagesStatisticsService;

@RestController
public class MessagesStatisticsController {

    @Autowired
    MessagesStatisticsService messagesStatisticsService;


    @GetMapping("/messages/statistics")
    public List<MessagesPerTypeStats> getStatistics() {
        return messagesStatisticsService.getStatistics();
    }
}
