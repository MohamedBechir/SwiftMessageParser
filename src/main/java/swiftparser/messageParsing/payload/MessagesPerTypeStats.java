package swiftparser.messageParsing.payload;

public class MessagesPerTypeStats {
    private String messageType;
    private String color;
    private Integer redundancy;


    public MessagesPerTypeStats(String messageType, String color, Integer redundancy) {
        this.messageType = messageType;
        this.color = color;
        this.redundancy = redundancy;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Integer getRedundancy() {
        return this.redundancy;
    }

    public void setRedundancy(Integer redundancy) {
        this.redundancy = redundancy;
    }


}
