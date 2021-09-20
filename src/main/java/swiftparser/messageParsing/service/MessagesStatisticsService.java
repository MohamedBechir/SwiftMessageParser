package swiftparser.messageParsing.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swiftparser.messageParsing.model.Block2;
import swiftparser.messageParsing.payload.MessagesPerTypeStats;
import swiftparser.messageParsing.repository.MessageRepository;
import swiftparser.messageParsing.repository.StatisticsRepository;

@Service
public class MessagesStatisticsService {

    @Autowired
    StatisticsRepository statisticsRepository;

    @Autowired
    MessageRepository messageRepository;

    List<String> colorsList = new ArrayList<>();

    public List<MessagesPerTypeStats> getMessagesPerType(){
        List<Block2> block2s = statisticsRepository.findAll();
        List<MessagesPerTypeStats> messagesPerTypeStats = new ArrayList<>();
        for (Block2 block2 : block2s) {
            List<BigInteger> stats = statisticsRepository.findByMessageType(block2.getMessageType());
            messagesPerTypeStats.add(new MessagesPerTypeStats(block2.getMessageType(), stats.get(0).intValue()));
        }
        return messagesPerTypeStats;
    }

    public List<String> getLastFiveMessages(){
        return statisticsRepository.findLastFiveMessages();
    }
}
