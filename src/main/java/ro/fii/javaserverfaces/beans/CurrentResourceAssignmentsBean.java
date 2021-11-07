package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.ExamsDao;
import ro.fii.javaserverfaces.dao.ResourcesDao;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

import static javax.ejb.ConcurrencyManagementType.BEAN;

@Named
@Singleton
@ConcurrencyManagement(BEAN)
public class CurrentResourceAssignmentsBean {
    @Getter
    @Setter
    private Map<Integer, Map<Integer, Integer>> resourcesAssignments = new HashMap<>();

    @EJB
    private ResourcesDao resourcesDao;

    @EJB
    private ExamsDao examsDao;

    public void addResourceToExam(Integer examId, Integer resourceId, Integer quantity) {
        resourcesAssignments.computeIfAbsent(examId, k -> new HashMap<>());
        Map<Integer, Integer> assignedResourcesForExam = resourcesAssignments.get(examId);
        if (assignedResourcesForExam.containsKey(resourceId)) {
            assignedResourcesForExam.put(resourceId, assignedResourcesForExam.get(resourceId) + quantity);
        } else {
            assignedResourcesForExam.put(resourceId, quantity);
        }
    }

    public String getExamNameById(Integer examId) {
        return examsDao.getById(examId).getName();
    }

    public String getResourceNameById(Integer resourceId) {
        return resourcesDao.getById(resourceId).getName();
    }
}
