package ro.fii.javaserverfaces.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@DiscriminatorValue("written test")
@NamedQueries({
        @NamedQuery(name = "WrittenTest.getAll", query = "SELECT exam FROM WrittenTest exam")
})
@NoArgsConstructor
public class WrittenTest extends Exam {
    @Column(name = "bibliography")
    private String bibliography;

    public WrittenTest(String name, Timestamp startingTime, Float duration, String bibliography) {
        super(name, startingTime, duration);
        this.bibliography = bibliography;
    }
}
