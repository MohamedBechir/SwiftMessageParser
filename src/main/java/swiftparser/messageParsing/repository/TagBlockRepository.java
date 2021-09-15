package swiftparser.messageParsing.repository;


import org.springframework.data.repository.CrudRepository;

import swiftparser.messageParsing.model.TagBlock;


public interface TagBlockRepository extends CrudRepository<TagBlock, Long> {
    
}
