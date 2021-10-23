package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.entities.AbstractEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AutoCompleteViewBean<T extends AbstractEntity<ID>, ID> implements Serializable {
    @Getter
    @Setter
    protected String txt;

    public List<String> completeText() {
        return new ArrayList<>();
    }
}
