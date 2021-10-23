package ro.fii.javaserverfaces.entities;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Exam extends AbstractEntity<Integer> {
    private String name;
    private Timestamp startingTime;
    private Float duration;

    public Exam(Integer id, String name, Timestamp startingTime, Float duration) {
        super(id);
        this.name = name;
        this.startingTime = startingTime;
        this.duration = duration;
    }
}
