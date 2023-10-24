package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_maintenance_mode")
public class MaintenanceModeEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_maintenance_gen")
    @SequenceGenerator(name = "mst_maintenance_gen", sequenceName = "maintenance_id_seq", allocationSize = 1)
    @Column(name = "maintenance_id")
    private Integer maintenanceId;

    @Column(name = "maintenance_content")
    @Type(type = "text")
    private String maintenanceContent;

    @Column(name = "maintenance_headline")
    private String maintenanceHeadline;

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

    public MaintenanceModeEntity() {

    }

    public MaintenanceModeEntity(String maintenanceHeadline, String maintenanceContent, Integer status, Integer createdBy, Date createdAt) {
        this.maintenanceHeadline = maintenanceHeadline;
        this.maintenanceContent = maintenanceContent;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getMaintenanceContent() {
        return maintenanceContent;
    }

    public void setMaintenanceContent(String maintenanceContent) {
        this.maintenanceContent = maintenanceContent;
    }

    public String getMaintenanceHeadline() {
        return maintenanceHeadline;
    }

    public void setMaintenanceHeadline(String maintenanceHeadline) {
        this.maintenanceHeadline = maintenanceHeadline;
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
