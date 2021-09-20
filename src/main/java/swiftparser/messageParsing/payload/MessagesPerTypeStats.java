package swiftparser.messageParsing.payload;

public class MessagesPerTypeStats {
    private String name;
    private Integer value;

    public MessagesPerTypeStats(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
