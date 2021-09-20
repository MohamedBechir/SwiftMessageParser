package swiftparser.messageParsing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import swiftparser.messageParsing.model.AbstractSwiftMessage;


public interface MessageRepository extends JpaRepository<AbstractSwiftMessage, Long> {
}