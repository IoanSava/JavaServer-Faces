package ro.fii.javaserverfaces.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String assignedExams;
}
