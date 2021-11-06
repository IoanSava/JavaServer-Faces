package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;

public class DataViewBean<T extends AbstractEntity> implements Serializable {
    @Getter
    @Setter
    protected T selectedEntity;
    protected List entities;

    public List<T> getEntities() {
        return entities;
    }
}
