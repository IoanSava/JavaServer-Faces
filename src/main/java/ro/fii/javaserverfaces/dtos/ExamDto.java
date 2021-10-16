package ro.fii.javaserverfaces.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class ExamDto {
    private String name;
    private Timestamp startingTime;
    private Float duration;
}
