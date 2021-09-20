package swiftparser.messageParsing.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swiftparser.messageParsing.model.Block2;
import swiftparser.messageParsing.payload.MessagesPerTypeStats;
import swiftparser.messageParsing.repository.StatisticsRepository;

@Service
public class MessagesStatisticsService {

    @Autowired
    StatisticsRepository statisticsRepository;

    List<String> colorsList = new ArrayList<>();

    public List<MessagesPerTypeStats> getStatistics(){
        colorsList.add("#0088FE");
        colorsList.add("#00C49F");
        colorsList.add("#F49D37");
        colorsList.add("#FF8042");
        colorsList.add("#FFF");
        colorsList.add("#b22c2c");
        colorsList.add("#fb8585");
        colorsList.add("#d1d1e5");
        colorsList.add("#ccabc5");
        colorsList.add("#e8c273");
        colorsList.add("#7ca661");
        colorsList.add("#ab8970");


        List<Block2> block2s = statisticsRepository.findAll();
        List<MessagesPerTypeStats> messagesPerTypeStats = new ArrayList<>();
        for (Block2 block2 : block2s) {
            List<BigInteger> stats = statisticsRepository.findByMessageType(block2.getMessageType());
            messagesPerTypeStats.add(new MessagesPerTypeStats(block2.getMessageType(), colorsList.get(ThreadLocalRandom.current().nextInt(0, 5 + 1)), stats.get(0).intValue()));
        }
        return messagesPerTypeStats;

    }
}
