package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_setting_group")
public class SettingGroupEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_setting_group_gen")
    @SequenceGenerator(name = "mst_setting_group_gen", sequenceName = "setting_group_id_seq", allocationSize = 1)
    @Column(name = "setting_group_id")
    private Integer settingGroupId;

    @Column(name = "setting_group_name")
    private String settingGroupName;

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

    public SettingGroupEntity() {
    }

    public SettingGroupEntity(String settingGroupName, String startDate, String endDate, Integer status, Integer createdBy, Date createdAt) {
        this.settingGroupName = settingGroupName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getSettingGroupId() {
        return settingGroupId;
    }

    public void setSettingGroupId(Integer settingGroupId) {
        this.settingGroupId = settingGroupId;
    }

    public String getSettingGroupName() {
        return settingGroupName;
    }

    public void setSettingGroupName(String settingGroupName) {
        this.settingGroupName = settingGroupName;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
