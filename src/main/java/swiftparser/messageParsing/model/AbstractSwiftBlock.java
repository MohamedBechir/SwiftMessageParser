package swiftparser.messageParsing.model;

// import java.util.Set;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractSwiftBlock {

    @Id
    private Integer id;
    
    // private Set<AbstractBlockField> fields;
    private boolean startBlock, endBlock;

    public Integer getId() {
        return id;
    }

    public boolean isStartBlock() {
        return startBlock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   /* public void setFields(Set<AbstractBlockField> fields) {
        this.fields = fields;
    }

    public Set<AbstractBlockField> getFields() {
        return fields;
    } */

    public void setStartBlock(boolean startBlock) {
        this.startBlock = startBlock;
    }

    public void setEndBlock(boolean endBlock) {
        this.endBlock = endBlock;
    }

    public boolean isEndBlock() {
        return endBlock;
    }
}
