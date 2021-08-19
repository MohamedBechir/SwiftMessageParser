package swiftparser.messageParsing.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TagBlock extends AbstractSwiftBlock {

    private Integer blockNumber;
    
    @OneToMany(cascade = CascadeType.ALL)  
    private Set<AbstractBlockField> fields;

    public void setFields(Set<AbstractBlockField> fields) {
        this.fields = fields;
    }

    public Set<AbstractBlockField> getFields() {
        return fields;
    }


    public Integer getBlockNumber() {
        return this.blockNumber;
    }

    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

}
