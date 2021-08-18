package swiftparser.messageParsing.repository;

import org.springframework.data.repository.CrudRepository;

import swiftparser.messageParsing.model.AbstractSwiftMessage;


public interface MessageRepository extends CrudRepository<AbstractSwiftMessage, Long> {
    
}
