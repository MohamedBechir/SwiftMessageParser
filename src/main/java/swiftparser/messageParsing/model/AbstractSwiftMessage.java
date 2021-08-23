package swiftparser.messageParsing.model;


import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class AbstractSwiftMessage implements Auditable<String, Integer, LocalDateTime > {

    @OneToOne
    @JoinColumn(name = "block1_id")
    private Block1 block1;

    @OneToOne
    @JoinColumn(name = "block2_id")
    private Block2 block2;

    @OneToMany
    private Set<TagBlock> tagBlocks;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "swiftMessageIdGenerator")
    @SequenceGenerator(name = "swiftMessageIdGenerator", sequenceName = "swiftId")
    protected Long id;

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifieDate;

    @Lob
    protected Byte[] messageBody;

    protected Long fileSize;

    public AbstractSwiftMessage(String createdBy, Date createdDate, String lastModifiedBy, Date lastModifieDate, Long fileSize)
    {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifieDate = lastModifieDate;
        this.fileSize = fileSize;
    }

    public AbstractSwiftMessage() {}

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public Optional<String> getCreatedBy() {
        return Optional.ofNullable(createdBy);
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;        
    }

    @Override
    public Optional<LocalDateTime> getCreatedDate() {
        return null == createdDate ? Optional.empty() : Optional.of(LocalDateTime.ofInstant(createdDate.toInstant(),ZoneId.systemDefault()));
    }

    @Override
    public void setCreatedDate(LocalDateTime creationDate) {
        this.createdDate = Date.from(creationDate.atZone(ZoneId.systemDefault()).toInstant());       
    }

    @Override
    public Optional<String> getLastModifiedBy() {
        return Optional.ofNullable(lastModifiedBy);
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public Optional<LocalDateTime> getLastModifiedDate() {
        return null == lastModifieDate ? Optional.empty() : Optional.of(LocalDateTime.ofInstant(lastModifieDate.toInstant(), ZoneId.systemDefault()));
    }

    @Override
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifieDate = Date.from(lastModifiedDate.atZone(ZoneId.systemDefault()).toInstant());       
    }

    public void setMessageBody(Byte[] messageBody){
        this.messageBody = messageBody;
    }

    public Byte[] getMessageBody(){
        return this.messageBody;
    }

    public void setFileSize(Long fileSize){
        this.fileSize = fileSize;
    }

    public Long getFileSize(){
        return this.fileSize;
    }

    public void setBlock1(Block1 block1) {
        this.block1 = block1;
    }

    public Block1 getBlock1() {
        return block1;
    }

    public void setBlock2(Block2 block2) {
        this.block2 = block2;
    }

    public Block2 getBlock2() {
        return block2;
    }

    public void setTagBlock(Set<TagBlock> tagBlocks) {
        this.tagBlocks = tagBlocks;
    }

    public Set<TagBlock> getTagBlock() {
        return tagBlocks;
    }
}