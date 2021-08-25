package swiftparser.messageParsing.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@MappedSuperclass
public class AbstractSwiftBlock {


    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blockIdGenerator")
    @SequenceGenerator(name = "blockIdGenerator", sequenceName = "blockId")
    private Integer id;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

}
