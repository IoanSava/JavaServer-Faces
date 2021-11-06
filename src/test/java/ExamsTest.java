import org.junit.Assert;
import org.junit.Test;
import ro.fii.javaserverfaces.entities.ProjectPresentation;

import java.sql.Timestamp;
import java.util.List;

public class ExamsTest extends JPATest {
    @Test
    public void selectAllWrittenTests_shouldReturn1Exam_when1WrittenTestIsInDatabase() {
        entityManager.getTransaction().begin();
        List exams = entityManager.createQuery("SELECT exam FROM WrittenTest exam").getResultList();
        entityManager.getTransaction().commit();

        Assert.assertEquals(exams.size(), 1);
    }

    @Test
    public void selectAllProjectPresentations_shouldReturn3ProjectPresentations_when3ProjectPresentationsAreInDatabase() {
        entityManager.getTransaction().begin();
        List exams = entityManager.createQuery("SELECT exam FROM ProjectPresentation exam").getResultList();
        entityManager.getTransaction().commit();

        Assert.assertEquals(exams.size(), 3);
    }

    @Test
    public void create_shouldCreateProjectPresentation() {
        entityManager.getTransaction().begin();
        ProjectPresentation projectPresentation = new ProjectPresentation("Test exam", new Timestamp(System.currentTimeMillis()), 2.0F, true);
        entityManager.persist(projectPresentation);
        entityManager.getTransaction().commit();
    }
}
