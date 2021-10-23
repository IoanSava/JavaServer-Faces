package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.ExamsDao;
import ro.fii.javaserverfaces.entities.Exam;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class ExamAutoCompleteViewBean extends AutoCompleteViewBean<Exam, Integer> {
    private final ExamsDao examsDao;

    public ExamAutoCompleteViewBean() throws NamingException {
        examsDao = new ExamsDao();
    }

    public List<String> completeText(String query) throws SQLException {
        String queryLowerCase = query.toLowerCase();
        List<String> examList = new ArrayList<>();
        List<Exam> exams = examsDao.getAll();
        for (Exam exam : exams) {
            examList.add(exam.getName());
        }

        return examList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
}
