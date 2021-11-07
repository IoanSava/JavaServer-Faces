package ro.fii.javaserverfaces.beans;

import lombok.Getter;
import lombok.Setter;
import ro.fii.javaserverfaces.dao.ExamsDao;
import ro.fii.javaserverfaces.dao.ResourcesDao;
import ro.fii.javaserverfaces.dtos.UpdateResourceDto;
import ro.fii.javaserverfaces.entities.Exam;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Getter
@Setter
@Stateful
@LocalBean
@SessionScoped
public class ResourceAssignmentBean implements Serializable {
    @EJB
    private ResourcesDao resourcesDao;

    @EJB
    private ExamsDao examsDao;

    @EJB
    private CurrentResourceAssignmentsBean currentResourceAssignmentsBean;

    private int examId;
    private String necessaryResources;

    @Remove
    public void submit() {
        Exam exam = examsDao.getById(this.examId);
        if (exam != null) {
            List<UpdateResourceDto> updateResourceDtos = convertNecessaryResourcesToUpdateResourceDtos(this.necessaryResources);
            boolean isUpdateFailed = resourcesDao.updateInBulk(updateResourceDtos);
            if (!isUpdateFailed) {
                for (UpdateResourceDto updateResourceDto : updateResourceDtos) {
                    currentResourceAssignmentsBean.addResourceToExam(examId, updateResourceDto.getId(), updateResourceDto.getQuantity());
                }
            }
        }
    }

    private List<UpdateResourceDto> convertNecessaryResourcesToUpdateResourceDtos(String necessaryResources) {
        List<UpdateResourceDto> updateResourceDtos = new ArrayList<>();
        String[] necessaryResourcesSplitByComma = necessaryResources.split(",");
        for (String necessaryResource : necessaryResourcesSplitByComma) {
            String[] necessaryResourceSplitByDash = necessaryResource.split("-");
            Integer resourceId = Integer.parseInt(necessaryResourceSplitByDash[0]);
            Integer quantity = Integer.parseInt(necessaryResourceSplitByDash[1]);
            updateResourceDtos.add(new UpdateResourceDto(resourceId, quantity));
        }
        return updateResourceDtos;
    }
}
