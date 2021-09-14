package swiftparser.messageParsing.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonRootName;

/*
Blocks that contain tags(3, 4, 5)
*/
@Entity
@JsonRootName("TagBlocks")
public class TagBlock extends AbstractSwiftBlock {

    private Integer blockNumber;
    private String blockName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  
    private Set<AbstractBlockField> fields;

    public Integer getBlockNumber() {
        return this.blockNumber;
    }

    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setFields(Set<AbstractBlockField> fields) {
        this.fields = fields;
    }

    public Set<AbstractBlockField> getFields() {
        return fields;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

}
