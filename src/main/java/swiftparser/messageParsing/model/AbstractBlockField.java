package swiftparser.messageParsing.model;

import org.springframework.lang.NonNull;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractBlockField {
    @NonNull
    private String tagName;

    @NonNull
    private String tagValue;

    @NonNull
    public String getTagName() {
        return tagName;
    }

    @NonNull
    public String getTagValue() {
        return tagValue;
    }

    public void setTagName(@NonNull String tagName) {
        this.tagName = tagName;
    }

    public void setTagValue(@NonNull String tagValue) {
        this.tagValue = tagValue;
    }
}
