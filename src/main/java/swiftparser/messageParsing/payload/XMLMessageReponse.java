package swiftparser.messageParsing.payload;

public class XMLMessageReponse {
    private String messages;
    private String messageID;
    private String messageType;
    private boolean sentXml;

    public XMLMessageReponse(String string, String messageID, String messageType, boolean sentXml) {
        this.messages = string;
        this.sentXml = sentXml;
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


    public boolean isSentXml() {
        return this.sentXml;
    }

    public boolean getSentXml() {
        return this.sentXml;
    }

    public void setSentXml(boolean sentXml) {
        this.sentXml = sentXml;
    }

}
