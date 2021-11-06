package ro.fii.javaserverfaces.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class ExamFilters {
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;

    private boolean useNameFilter;
    private boolean useStartDateFilter;
    private boolean useEndDateFilter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = DateUtils.getTimestamp(startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = DateUtils.getTimestamp(endDate);
    }

    public boolean isUseNameFilter() {
        return useNameFilter;
    }

    public void setUseNameFilter(boolean useNameFilter) {
        this.useNameFilter = useNameFilter;
    }

    public boolean isUseStartDateFilter() {
        return useStartDateFilter;
    }

    public void setUseStartDateFilter(boolean useStartDateFilter) {
        this.useStartDateFilter = useStartDateFilter;
    }

    public boolean isUseEndDateFilter() {
        return useEndDateFilter;
    }

    public void setUseEndDateFilter(boolean useEndDateFilter) {
        this.useEndDateFilter = useEndDateFilter;
    }
}
