package com.okane.domain.transaction;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_document")
public class DocumentEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trx_document_gen")
    @SequenceGenerator(name = "trx_document_gen", sequenceName = "document_id_seq", allocationSize = 1)
    @Column(name = "document_id")
    private Integer documentId;

    @Column(name = "setting_id")
    private Integer settingId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "document_filepath")
    private String documentFilepath;

    @Column(name = "document_month")
    private String documentMonth;

    @Column(name = "document_periode")
    private String documentPeriode;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_size")
    private Long documentSize;

    @Column(name = "description")
    private String description;

    // Anton
    @Column(name= "is_cafrm_docs")
    private boolean isCAFRM_Docs;

    @Column(name = "submenu_id")
    private Integer submenuId;

    @Column(name = "cafrm_docs_version")
    private Integer CAFRMDocsVersion;

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

    public DocumentEntity() {
    }

    public DocumentEntity(Integer settingId, Integer companyId, String documentName, String documentFilepath, String documentMonth, String documentPeriode, String documentType, Long documentSize, String description, Integer status, Integer createdBy, Date createdAt) {
        this.settingId = settingId;
        this.companyId = companyId;
        this.documentName = documentName;
        this.documentFilepath = documentFilepath;
        this.documentMonth = documentMonth;
        this.documentPeriode = documentPeriode;
        this.documentType = documentType;
        this.documentSize = documentSize;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentFilepath() {
        return documentFilepath;
    }

    public void setDocumentFilepath(String documentFilepath) {
        this.documentFilepath = documentFilepath;
    }

    public String getDocumentMonth() {
        return documentMonth;
    }

    public void setDocumentMonth(String documentMonth) {
        this.documentMonth = documentMonth;
    }

    public String getDocumentPeriode() {
        return documentPeriode;
    }

    public void setDocumentPeriode(String documentPeriode) {
        this.documentPeriode = documentPeriode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Long getDocumentSize() {
        return documentSize;
    }

    public void setDocumentSize(Long documentSize) {
        this.documentSize = documentSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isCAFRM_Docs() {
        return isCAFRM_Docs;
    }

    public void setCAFRM_Docs(boolean CAFRM_Docs) {
        isCAFRM_Docs = CAFRM_Docs;
    }

    public Integer getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(Integer submenuId) {
        this.submenuId = submenuId;
    }

    public Integer getCAFRMDocsVersion() {
        return CAFRMDocsVersion;
    }

    public void setCAFRMDocsVersion(Integer CAFRMDocsVersion) {
        this.CAFRMDocsVersion = CAFRMDocsVersion;
    }

}
