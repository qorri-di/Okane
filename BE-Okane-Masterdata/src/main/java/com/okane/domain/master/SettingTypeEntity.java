package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_setting_type")
public class SettingTypeEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_setting_type_gen")
    @SequenceGenerator(name = "mst_setting_type_gen", sequenceName = "setting_type_id_seq", allocationSize = 1)
    @Column(name = "setting_type_id")
    private Integer settingTypeId;

    @Column(name = "setting_type_name")
    private String settingTypeName;

    @Column(name = "parent")
    private Integer parent;

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

    public SettingTypeEntity() {
    }

    public SettingTypeEntity(String settingTypeName, Integer parent, String startDate, String endDate, Integer status, Integer createdBy, Date createdAt) {
        this.settingTypeName = settingTypeName;
        this.parent = parent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getSettingTypeId() {
        return settingTypeId;
    }

    public void setSettingTypeId(Integer settingTypeId) {
        this.settingTypeId = settingTypeId;
    }

    public String getSettingTypeName() {
        return settingTypeName;
    }

    public void setSettingTypeName(String settingTypeName) {
        this.settingTypeName = settingTypeName;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
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
