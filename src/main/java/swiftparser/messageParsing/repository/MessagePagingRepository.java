package swiftparser.messageParsing.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.transaction.Transactional;

import swiftparser.messageParsing.model.AbstractSwiftMessage;

@Transactional
public interface MessagePagingRepository extends PagingAndSortingRepository<AbstractSwiftMessage, String>{
    @Query(value = "SELECT b  FROM AbstractSwiftMessage b WHERE block2_id IN (SELECT id FROM Block2 WHERE message_type=:messageType)")
    List<AbstractSwiftMessage> findByBlock2MessageType(@Param("messageType") String messageType);
}
