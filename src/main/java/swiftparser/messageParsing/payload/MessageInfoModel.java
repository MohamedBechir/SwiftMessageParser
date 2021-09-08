package swiftparser.messageParsing.payload;

import java.util.Date;

public class MessageInfoModel {

    private Long id;
    private String senderBIC;
    private String receiverBIC;
    private String messageType;
    private Date createdAt;

    public MessageInfoModel(){}

    public MessageInfoModel(Long id, String senderBIC, String receiverBIC, String messageType, Date createdAt){
        this.id = id;
        this.senderBIC = senderBIC;
        this.receiverBIC = receiverBIC;
        this.messageType = messageType;
        this.createdAt = createdAt;
    }

    public Long getId(){
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

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setId(Long id){
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

    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }
    
}
