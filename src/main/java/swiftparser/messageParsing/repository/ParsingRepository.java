package swiftparser.messageParsing.repository;


import org.springframework.data.repository.CrudRepository;

import swiftparser.messageParsing.model.AbstractSwiftBlock;


public interface ParsingRepository extends CrudRepository<AbstractSwiftBlock, Long> {
    
}
