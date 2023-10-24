package com.okane.domain.transaction;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_activity_log")
public class LogActivityEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_log_activity_gen")
    @SequenceGenerator(name = "trx_log_activity_gen", sequenceName = "log_activity_id_seq", allocationSize = 1)
    @Column(name = "log_activity_id")
    private Integer logActivityId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "modules")
    private String modules;

    @Column(name = "module_id")
    private Integer moduleId;

    @Column(name = "activity")
    private String activity;

    @Column(name = "activity_type")
    private String activityType;

    @Column(name = "url")
    private String url;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    public LogActivityEntity() {
    }

    public LogActivityEntity(Integer userId, String modules, Integer moduleId, String activity, String activityType, String url, Integer createdBy, Date createdAt) {
        this.userId = userId;
        this.modules = modules;
        this.moduleId = moduleId;
        this.activity = activity;
        this.activityType = activityType;
        this.url = url;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getLogActivityId() {
        return logActivityId;
    }

    public void setLogActivityId(Integer logActivityId) {
        this.logActivityId = logActivityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
