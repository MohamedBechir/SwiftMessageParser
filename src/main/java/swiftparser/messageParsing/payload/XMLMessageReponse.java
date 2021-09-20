package swiftparser.messageParsing.payload;

public class XMLMessageReponse {
    private String messages;
    private String messageID;
    private String messageType;

    public XMLMessageReponse(String string, String messageID, String messageType) {
        this.messages = string;
        this.messageID = messageID;
        this.messageType = messageType;
    }

    public String getMessages() {
        return this.messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getMessageID() {
        return this.messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

}
