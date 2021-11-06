package ro.fii.javaserverfaces.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "exams")
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Exam.getAll", query = "SELECT exam FROM Exam exam")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="exam_type",
        discriminatorType = DiscriminatorType.STRING)
public class Exam extends AbstractEntity implements Serializable {
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "starting_time")
    private Timestamp startingTime;

    @Basic(optional = false)
    @Column(name = "duration")
    private Float duration;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "assignedExams")
    private List<Student> students = new ArrayList<>();

    public Exam(String name, Timestamp startingTime, Float duration) {
        this.name = name;
        this.startingTime = startingTime;
        this.duration = duration;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
