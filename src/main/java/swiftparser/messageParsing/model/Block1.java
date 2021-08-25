package swiftparser.messageParsing.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@JsonRootName("Block1")
public class Block1 extends AbstractSwiftBlock{

    @Column
    private String applicationId = "F";
    @Column
    private String serviceId = "01";
    @Column
    private String logicalTerminal;
    @Column
    private String sessionNumber = "0000";
    @Column
    private String sequenceNumber= "000000";

    public Block1(){}
    public Block1( String applicationId, String serviceId, String logicalTerminal, String sessionNumber, String sequenceNumber) {
        this.applicationId = applicationId;
        this.serviceId = serviceId;
        this.logicalTerminal = logicalTerminal;
        this.sessionNumber = sessionNumber;
        this.sequenceNumber = sequenceNumber;
    }

    public Integer getNumber() {
        return 1;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getLogicalTerminal() {
        return logicalTerminal;
    }

    public void setLogicalTerminal(String logicalTerminal) {
        this.logicalTerminal = logicalTerminal;
    }

    public String getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(String sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
}
