package swiftparser.messageParsing.payload;

import java.util.Set;

import swiftparser.messageParsing.model.Block1;
import swiftparser.messageParsing.model.Block2;
import swiftparser.messageParsing.model.TagBlock;

public class MessageDetailedInfoModel {
    String messageId;
    Block1 block1;
    Block2 block2;
    boolean sentJson;
    Set<TagBlock> tagBlock;


    public MessageDetailedInfoModel(Block1 block1, Block2 block2, Set<TagBlock> tagBlock, String messageId, boolean sent) {
        this.messageId = messageId;
        this.sentJson = sent;
        this.block1 = block1;
        this.block2 = block2;
        this.tagBlock = tagBlock;
    }


    public MessageDetailedInfoModel(Block1 block1, Block2 block2, Set<TagBlock> tagBlock) {
        this.block1 = block1;
        this.block2 = block2;
        this.tagBlock = tagBlock;
    }


    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Block1 getBlock1() {
        return this.block1;
    }

    public void setBlock1(Block1 block1) {
        this.block1 = block1;
    }

    public Block2 getBlock2() {
        return this.block2;
    }

    public void setBlock2(Block2 block2) {
        this.block2 = block2;
    }

    public Set<TagBlock> getTagBlock() {
        return this.tagBlock;
    }

    public void setTagBlock(Set<TagBlock> tagBlock) {
        this.tagBlock = tagBlock;
    }


    public boolean isSentJson() {
        return this.sentJson;
    }

    public boolean getSent() {
        return this.sentJson;
    }

    public void setSentJson(boolean sentJson) {
        this.sentJson = sentJson;
    }

}
