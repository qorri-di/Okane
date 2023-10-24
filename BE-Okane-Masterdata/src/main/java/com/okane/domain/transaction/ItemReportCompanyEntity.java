package com.okane.domain.transaction;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_item_report_company")
public class ItemReportCompanyEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_item_report_company_gen")
    @SequenceGenerator(name = "trx_item_report_company_gen", sequenceName = "item_report_company_id_seq", allocationSize = 1)
    @Column(name = "item_report_company_id")
    private Integer itemReportCompanyId;

    @JoinColumn(name = "item_report_id")
    private Integer itemReportId;

    @JoinColumn(name = "company_id")
    private Integer companyId;

    @JoinColumn(name = "report_id")
    private Integer reportId;

    @Column(name = "years")
    private Integer years;

    @Column(name = "weight")
    private String weight;

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

    public ItemReportCompanyEntity() {
    }

    public ItemReportCompanyEntity(Integer itemReportId, Integer companyId, Integer reportId, String weight, Integer years, Integer status, Integer createdBy, Date createdAt) {
        this.itemReportId = itemReportId;
        this.companyId = companyId;
        this.reportId = reportId;
        this.weight = weight;
        this.years = years;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getItemReportCompanyId() {
        return itemReportCompanyId;
    }

    public void setItemReportCompanyId(Integer itemReportCompanyId) {
        this.itemReportCompanyId = itemReportCompanyId;
    }

    public Integer getItemReportId() {
        return itemReportId;
    }

    public void setItemReportId(Integer itemReportId) {
        this.itemReportId = itemReportId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
