package swiftparser.messageParsing.payload;

import java.util.ArrayList;

public class GeneralInfoPagination {
    ArrayList<MessageGeneralInfoModel> messageGeneralInfoModels;
    private String pageSize;
    private String pageNumber;
    private String totalPages;

    public GeneralInfoPagination() {
    }

    public ArrayList<MessageGeneralInfoModel> getMessageGeneralInfoModels() {
        return this.messageGeneralInfoModels;
    }

    public void setMessageGeneralInfoModels(ArrayList<MessageGeneralInfoModel> messageGeneralInfoModels) {
        this.messageGeneralInfoModels = messageGeneralInfoModels;
    }

    public String getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }


    public ArrayList<MessageGeneralInfoModel> getMessageGeneralInfoModel() {
        return this.messageGeneralInfoModels;
    }

    public void setMessageGeneralInfoModel(ArrayList<MessageGeneralInfoModel> messageGeneralInfoModel) {
        this.messageGeneralInfoModels = messageGeneralInfoModel;
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
