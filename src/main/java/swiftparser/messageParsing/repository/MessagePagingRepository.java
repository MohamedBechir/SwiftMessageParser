package swiftparser.messageParsing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import swiftparser.messageParsing.model.AbstractSwiftMessage;

public interface MessagePagingRepository extends PagingAndSortingRepository<AbstractSwiftMessage, Long>{
    
}
