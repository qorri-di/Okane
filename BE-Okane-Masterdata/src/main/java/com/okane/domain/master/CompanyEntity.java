package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

public class CompanyEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_company_gen")
    @SequenceGenerator(name = "mst_company_gen", sequenceName = "company_id_seq", allocationSize = 1)
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "business_unit_id")
    private Integer businessUnitId;

    @Column(name = "parent")
    private Integer parent;

    @Column(name = "level")
    private Integer level;

    @Column(name = "total_report")
    private Integer totalReport;

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

    public CompanyEntity() {
    }

    public CompanyEntity(String companyName, Integer businessUnitId, Integer parent, Integer level, Integer totalReport, String startDate, String endDate, Integer status, Integer createdBy, Date createdAt) {
        this.companyName = companyName;
        this.businessUnitId = businessUnitId;
        this.parent = parent;
        this.level = level;
        this.totalReport = totalReport;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getBusinessUnitId() {
        return businessUnitId;
    }

    public Integer getParent() {
        return parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTotalReport() {
        return totalReport;
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

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBusinessUnitId(Integer businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public void setTotalReport(Integer totalReport) {
        this.totalReport = totalReport;
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
