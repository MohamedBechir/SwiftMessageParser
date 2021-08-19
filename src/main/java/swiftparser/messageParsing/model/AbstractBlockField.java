package swiftparser.messageParsing.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AbstractBlockField {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fieldIdGenerator")
    @SequenceGenerator(name = "fieldIdGenerator", sequenceName = "fieldId")
    private Integer id;

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
