package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_type_item_report")
public class TypeItemReportEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_type_item_report_gen")
    @SequenceGenerator(name = "mst_type_item_report_gen", sequenceName = "type_item_report_id_seq", allocationSize = 1)
    @Column(name = "type_item_report_id")
    private Integer typeItemReportId;

    @Column(name = "type_item_report_name")
    private String typeItemReportName;

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

    public TypeItemReportEntity() {
    }

    public TypeItemReportEntity(String typeItemReportName, Integer status, Integer createdBy, Date createdAt) {
        this.typeItemReportName = typeItemReportName;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getTypeItemReportId() {
        return typeItemReportId;
    }

    public void setTypeItemReportId(Integer typeItemReportId) {
        this.typeItemReportId = typeItemReportId;
    }

    public String getTypeItemReportName() {
        return typeItemReportName;
    }

    public void setTypeItemReportName(String typeItemReportName) {
        this.typeItemReportName = typeItemReportName;
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
