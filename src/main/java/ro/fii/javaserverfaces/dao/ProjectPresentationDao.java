package ro.fii.javaserverfaces.dao;

import ro.fii.javaserverfaces.entities.ProjectPresentation;
import ro.fii.javaserverfaces.utils.ExamFilters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProjectPresentationDao extends ExamsDao<ProjectPresentation> {
    @Override
    public List<ProjectPresentation> getAll(ExamFilters examFilters) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectPresentation> query = builder.createQuery(ProjectPresentation.class);
        Root<ProjectPresentation> root = query.from(ProjectPresentation.class);
        Predicate filter = builder.conjunction();

        if (examFilters.isUseNameFilter()) {
            if (examFilters.getName() != null && !examFilters.getName().equals("")) {
                filter = builder.and(filter, builder.like(root.get("name"), "%" + examFilters.getName() + "%"));
            }
        }

        if (examFilters.isUseStartDateFilter()) {
            if (examFilters.getStartDate() != null) {
                filter = builder.and(filter, builder.greaterThanOrEqualTo(root.get("startingTime"), examFilters.getStartDate()));
            }
        }

        if (examFilters.isUseEndDateFilter()) {
            if (examFilters.getEndDate() != null) {
                filter = builder.and(filter, builder.lessThanOrEqualTo(root.get("startingTime"), examFilters.getEndDate()));
            }
        }

        query.where(filter);
        return entityManager.createQuery(query).getResultList();
    }
}
