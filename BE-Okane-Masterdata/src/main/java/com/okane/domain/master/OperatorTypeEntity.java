package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_operator_type")
public class OperatorTypeEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_operator_type_gen")
    @SequenceGenerator(name = "mst_operator_type_gen", sequenceName = "operator_type_id_seq", allocationSize = 1)
    @Column(name = "operator_type_id")
    private Integer operatorTypeId;

    @Column(name = "operator_type_name")
    private String operatorTypeName;

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

    public OperatorTypeEntity() {
    }

    public OperatorTypeEntity(String operatorTypeName, String startDate, String endDate, Integer status, Integer createdBy, Date createdAt) {
        this.operatorTypeName = operatorTypeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getOperatorTypeId() {
        return operatorTypeId;
    }

    public void setOperatorTypeId(Integer operatorTypeId) {
        this.operatorTypeId = operatorTypeId;
    }

    public String getOperatorTypeName() {
        return operatorTypeName;
    }

    public void setOperatorTypeName(String operatorTypeName) {
        this.operatorTypeName = operatorTypeName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
