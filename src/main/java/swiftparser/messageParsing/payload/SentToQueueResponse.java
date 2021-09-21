package swiftparser.messageParsing.payload;

public class SentToQueueResponse {
    private String id;
    private boolean sent;
    private String sentOn;


    public SentToQueueResponse(String id, boolean sent, String sentOn) {
        this.id = id;
        this.sent = sent;
        this.sentOn = sentOn;
    }

    public boolean isSent() {
        return this.sent;
    }

    public boolean getSent() {
        return this.sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getSentOn() {
        return this.sentOn;
    }

    public void setSentOn(String sentOn) {
        this.sentOn = sentOn;
    }
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
