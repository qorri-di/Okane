package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_type_report")
public class TypeReportEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_type_report_gen")
    @SequenceGenerator(name = "mst_type_report_gen", sequenceName = "type_report_id_seq", allocationSize = 1)
    @Column(name = "type_report_id")
    private Integer typeReportId;

    @Column(name = "type_report_name")
    private String typeReportName;

    @Column(name = "approval_type_id")
    private Integer approvalTypeId;

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

    public TypeReportEntity() {
    }

    public TypeReportEntity(String typeReportName, Integer approvalTypeId, Integer status, Integer createdBy, Date createdAt) {
        this.typeReportName = typeReportName;
        this.approvalTypeId = approvalTypeId;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getTypeReportId() {
        return typeReportId;
    }

    public void setTypeReportId(Integer typeReportId) {
        this.typeReportId = typeReportId;
    }

    public String getTypeReportName() {
        return typeReportName;
    }

    public void setTypeReportName(String typeReportName) {
        this.typeReportName = typeReportName;
    }

    public Integer getApprovalTypeId() {
        return approvalTypeId;
    }

    public void setApprovalTypeId(Integer approvalTypeId) {
        this.approvalTypeId = approvalTypeId;
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
