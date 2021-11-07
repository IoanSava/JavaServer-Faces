package ro.fii.javaserverfaces.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "students")
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Student.getAll", query = "SELECT student FROM Student student")
})
public class Student extends AbstractEntity {
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "students_exams",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> assignedExams = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addExams(Exam... exams) {
        for (Exam exam : exams) {
            this.assignedExams.add(exam);
            exam.addStudent(this);
        }
    }

    public String getAssignedExamsAsIds() {
        StringBuilder assignedExamsIds = new StringBuilder();
        int numberOfAssignedExams = this.assignedExams.size();

        for (Exam exam : this.assignedExams) {
            assignedExamsIds.append(exam.getId());
            if (numberOfAssignedExams != 1) {
                assignedExamsIds.append(',');
            }
            --numberOfAssignedExams;
        }

        return assignedExamsIds.toString();
    }
}
