package ro.fii.javaserverfaces.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class Exam {
    private Integer id;
    private String name;
    private Timestamp startingTime;
    private Float duration;
}
