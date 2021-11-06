package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.ExamsDao;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public abstract class CreateExamBean implements Serializable {
    protected String name;
    protected Date startingTime;
    protected Float duration;
    protected ExamsDao examsDao;

    public abstract void submit();
}
