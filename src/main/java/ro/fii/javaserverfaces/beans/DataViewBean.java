package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.entities.AbstractEntity;

import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class DataViewBean<T extends AbstractEntity<ID>, ID> implements Serializable {
    @Getter
    @Setter
    protected T selectedEntity;
    protected List<T> entities;

    public List<T> getEntities() throws SQLException, NamingException {
        return entities;
    }
}
