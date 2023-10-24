package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_report")
public class ReportEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_report_gen")
    @SequenceGenerator(name = "mst_report_gen", sequenceName = "report_id_seq", allocationSize = 1)
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "report_name")
    private String reportName;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    public ReportEntity() {
    }

    public ReportEntity(String reportName, Integer status, String startDate, String endDate, Integer createdBy, Date createdAt) {
        this.reportName = reportName;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getReportId() {
        return reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
