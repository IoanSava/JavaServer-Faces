package ro.fii.javaserverfaces.beans;

import ro.fii.javaserverfaces.dao.WrittenTestDao;
import ro.fii.javaserverfaces.entities.WrittenTest;
import ro.fii.javaserverfaces.utils.ExamFilters;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class WrittenTestAutoCompleteViewBean extends AutoCompleteViewBean {
    private WrittenTestDao writtenTestDao;

    @PostConstruct
    public void init() {
        writtenTestDao = new WrittenTestDao();
    }

    public List<String> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> examList = new ArrayList<>();
        List<WrittenTest> exams = writtenTestDao.getAll(new ExamFilters());
        for (WrittenTest exam : exams) {
            examList.add(exam.getName());
        }

        return examList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
}
