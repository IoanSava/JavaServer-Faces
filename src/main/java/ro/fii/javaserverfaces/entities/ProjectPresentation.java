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
@DiscriminatorValue("project presentation")
@NamedQueries({
        @NamedQuery(name = "ProjectPresentation.getAll", query = "SELECT exam FROM ProjectPresentation exam")
})
@NoArgsConstructor
public class ProjectPresentation extends Exam {
    @Column(name = "are_teams_allowed")
    private boolean areTeamsAllowed;

    public ProjectPresentation(String name, Timestamp startingTime, Float duration, boolean areTeamsAllowed) {
        super(name, startingTime, duration);
        this.areTeamsAllowed = areTeamsAllowed;
    }
}
