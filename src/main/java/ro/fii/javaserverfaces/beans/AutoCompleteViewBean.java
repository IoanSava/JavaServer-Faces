package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AutoCompleteViewBean implements Serializable {
    @Getter
    @Setter
    protected String txt;

    public List<String> completeText() {
        return new ArrayList<>();
    }
}
