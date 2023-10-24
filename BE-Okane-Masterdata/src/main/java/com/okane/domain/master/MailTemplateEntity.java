package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_mail_template")
public class MailTemplateEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_mail_gen")
    @SequenceGenerator(name = "mst_mail_gen", sequenceName = "mail_id_seq", allocationSize = 1)
    @Column(name = "mail_id")
    private Integer mailId;

    @Column(name = "mail_name")
    private String mailName;

    @Column(name = "mail_subject")
    private String mailSubject;

    @Column(name = "mail_type")
    private String mailType;

    @Column(name = "mail_body")
    @Type(type = "text")
    private String mailBody;

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

    public MailTemplateEntity() {

    }

    public MailTemplateEntity(String mailName, String mailSubject, String mailType, String mailBody, Integer status, Integer createdBy, Date createdAt) {
        this.mailName = mailName;
        this.mailSubject = mailSubject;
        this.mailType = mailType;
        this.mailBody = mailBody;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getMailId() {
        return mailId;
    }

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
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
