package swiftparser.messageParsing.payload;

public class MessageSending {

    private String responseMessage;

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public MessageSending(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    
}
