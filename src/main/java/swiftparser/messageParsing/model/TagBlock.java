package swiftparser.messageParsing.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


/*
Blocks that contain tags(3, 4, 5)
*/
@Entity
public class TagBlock extends AbstractSwiftBlock {

    
    @OneToMany(cascade = CascadeType.ALL)  
    private Set<AbstractBlockField> fields;

    public void setFields(Set<AbstractBlockField> fields) {
        this.fields = fields;
    }

    public Set<AbstractBlockField> getFields() {
        return fields;
    }

}
