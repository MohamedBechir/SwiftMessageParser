package swiftparser.messageParsing.payload;


public class MessageGeneralInfoModel {

    private String id;
    private String senderBIC;
    private String receiverBIC;
    private String messageType;
    private String createdAt;
    private String totalPages;
    private String pageSize;
    private String pageNumber;

   
    public MessageGeneralInfoModel(){}


    public MessageGeneralInfoModel(String id, String senderBIC, String receiverBIC, String messageType, String createdAt, String totalPages, String pageSize, String pageNumber) {
        this.id = id;
        this.senderBIC = senderBIC;
        this.receiverBIC = receiverBIC;
        this.messageType = messageType;
        this.createdAt = createdAt;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
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

    public String getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
    

    public String getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

}
