package swiftparser.messageParsing.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SwiftBlock2 extends AbstractSwiftBlock{
    @Column
    private String messagePriority = "N";
    @Column
    private String messageType = null;

    public SwiftBlock2(){
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

    public boolean isInput(){
        return true;
    }

    public boolean isOutput(){
        return false;
    }

    /*
    public enum SwiftBlock2Field {
    Direction,
    MessageType,
    MessagePriority
    }
    
    public String field(SwiftBlock2Field field) {
        switch (field) {
            case Direction: {
                if (isInput()) {
                    return MessageDirection.Input.name();
                } else {
                    return MessageDirection.Output.name();
                }
            }
            case MessageType:
                return getMessageType();
            case MessagePriority:
                return getMessagePriority();
            default:
                return null;
        }
    }
    */

}
