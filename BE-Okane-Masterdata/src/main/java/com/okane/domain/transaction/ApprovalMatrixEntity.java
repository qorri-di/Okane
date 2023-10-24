package com.okane.domain.transaction;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_approval_matrix")
public class ApprovalMatrixEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_approval_matrix_gen")
    @SequenceGenerator(name = "trx_approval_matrix_gen", sequenceName = "approval_matrix_id_seq", allocationSize = 1)
    @Column(name = "approval_matrix_id")
    private Integer approvalMatrixId;

    @Column(name = "approval_type_id")
    private Integer approvalTypeId;

    @Column(name = "operator_type_id")
    private Integer operatorTypeId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "orders")
    private Integer orders;

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

    public ApprovalMatrixEntity() {
    }

    public ApprovalMatrixEntity(Integer approvalTypeId, Integer operatorTypeId, Integer userId, Integer orders, String startDate, String endDate, Integer status, Integer createdBy, Date createdAt) {
        this.approvalTypeId = approvalTypeId;
        this.operatorTypeId = operatorTypeId;
        this.userId = userId;
        this.orders = orders;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getApprovalMatrixId() {
        return approvalMatrixId;
    }

    public void setApprovalMatrixId(Integer approvalMatrixId) {
        this.approvalMatrixId = approvalMatrixId;
    }

    public Integer getApprovalTypeId() {
        return approvalTypeId;
    }

    public void setApprovalTypeId(Integer approvalTypeId) {
        this.approvalTypeId = approvalTypeId;
    }

    public Integer getOperatorTypeId() {
        return operatorTypeId;
    }

    public void setOperatorTypeId(Integer operatorTypeId) {
        this.operatorTypeId = operatorTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
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
