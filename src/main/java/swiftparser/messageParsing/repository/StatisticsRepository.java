package swiftparser.messageParsing.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import swiftparser.messageParsing.model.Block2;

public interface StatisticsRepository extends JpaRepository<Block2, Long> {
    @Query("SELECT COUNT(b) FROM Block2 b WHERE message_type=:messageType")
    List<BigInteger> findByMessageType(String messageType);

    @Query(value = "SELECT DISTINCT ON (message_type) * FROM Block2", nativeQuery = true)
    List<Block2> findAll();

    @Query(value = "SELECT DISTINCT message_type FROM Block2 ORDER by message_type DESC LIMIT 5", nativeQuery = true)
    List<String> findLastFiveMessages();
}
