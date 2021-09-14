package swiftparser.messageParsing.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@JsonRootName("Block2")
public class Block2 extends AbstractSwiftBlock{

    @Column
    private String messagePriority;
    @Column
    private String messageType;
    @Column 
    private String messageDirection;
    @Column
    private String blockName;

    public Block2(){
        super();
    }

    public Integer getNumber() {
        return 2;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessagePriority() {
        return messagePriority;
    }

    public void setMessagePriority(String messagePriority) {
        this.messagePriority = messagePriority;
    }


    public String getMessageDirection() {
        return this.messageDirection;
    }

    public void setMessageDirection(String messageDirection) {
        this.messageDirection = messageDirection;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

}
