package swiftparser.messageParsing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

import swiftparser.messageParsing.model.AbstractSwiftMessage;

@Transactional
public interface MessagePagingRepository extends PagingAndSortingRepository<AbstractSwiftMessage, Long>{
    @Query(value = "SELECT b  FROM AbstractSwiftMessage b WHERE block2_id IN (SELECT id FROM Block2 WHERE message_type=:messageType)")
    Page<AbstractSwiftMessage> findByBlock2MessageType(Pageable pageable, @Param("messageType") String messageType);
}
