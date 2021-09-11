package swiftparser.messageParsing.payload;


public class MessageGeneralInfoModel {

    private String id;
    private String senderBIC;
    private String receiverBIC;
    private String messageType;
    private String createdAt;

    public MessageGeneralInfoModel(){}

    public MessageGeneralInfoModel(String id, String senderBIC, String receiverBIC, String messageType, String createdAt){
        this.id = id;
        this.senderBIC = senderBIC;
        this.receiverBIC = receiverBIC;
        this.messageType = messageType;
        this.createdAt = createdAt;
    }

    public String getId(){
        return id;
    }

    public String getSenderBIC(){
        return senderBIC;
    }

    public String getReceiverBIC(){
        return receiverBIC;
    }

    public String getMessageType(){
        return messageType;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setSenderBIC(String senderBIC){
        this.senderBIC = senderBIC;
    }

    public void setReceiverBIC(String receiverBIC){
        this.receiverBIC = receiverBIC;
    }

    public void setMessageType(String messageType){
        this.messageType = messageType;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    
}
