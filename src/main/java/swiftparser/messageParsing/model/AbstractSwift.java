package swiftparser.messageParsing.model;

import java.util.Map;

public class AbstractSwift {

    private Map<Integer, AbstractSwiftBlock> swiftBlocks;

    public Map<Integer, AbstractSwiftBlock> getSwiftBlocks(){
        return swiftBlocks;
    }

    public AbstractSwiftBlock getSwiftBlockById(Integer blockId){
        return swiftBlocks.get(blockId);
    }
}