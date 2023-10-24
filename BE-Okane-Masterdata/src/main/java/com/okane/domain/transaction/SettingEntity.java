package com.okane.domain.transaction;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_setting")
public class SettingEntity extends PanacheEntityBase {
    @Id
    @Column(name = "setting_id")
    private Integer settingId;

    @Column(name = "setting_group_id")
    private Integer settingGroupId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "setting_type_id")
    private Integer settingTypeId;

    @Column(name = "reference_id")
    private Integer referenceId;

    @Column(name = "description")
    private String description;

    @Column(name = "orders")
    private Integer orders;

    @Column(name = "values")
    private String values;

    @Column(name = "min_value")
    private String minValue;

    @Column(name = "max_value")
    private String maxValue;

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

    public SettingEntity() {
    }

    public SettingEntity(Integer settingGroupId, Integer companyId, Integer settingTypeId, Integer referenceId, String description, Integer orders, String values, String minValue, String maxValue, String startDate, String endDate, Integer status, Integer createdBy, Date createdAt) {
        this.settingGroupId = settingGroupId;
        this.companyId = companyId;
        this.settingTypeId = settingTypeId;
        this.referenceId = referenceId;
        this.description = description;
        this.orders = orders;
        this.values = values;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public Integer getSettingGroupId() {
        return settingGroupId;
    }

    public void setSettingGroupId(Integer settingGroupId) {
        this.settingGroupId = settingGroupId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getSettingTypeId() {
        return settingTypeId;
    }

    public void setSettingTypeId(Integer settingTypeId) {
        this.settingTypeId = settingTypeId;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
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
