package com.okane.domain.master;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_item_report")
public class ItemReportEntity extends PanacheEntityBase {
    @Id
    @Column(name = "item_report_id")
    private Integer itemReportId;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "orders")
    private Integer orders;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "parent")
    private Integer parent;

    @Column(name = "level")
    private Integer level;

    @Column(name = "uom")
    private String uom;

    @Column(name = "weight")
    private String weight;

    @Column(name = "type_item_report_id")
    private Integer typeItemReportId;

    @Column(name = "formula")
    private String formula;

    @Column(name = "condition_it_should_be")
    private String conditionItShouldBe;

    @Column(name = "condition_if_wrong")
    private String conditionIfWrong;

    @Column(name = "kpi_type")
    private String typeKpi;

    @Column(name = "max_ach")
    private String maxAch;

    @Column(name = "formula_ytd")
    private String formulaYtd;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "is_can_convert_value")
    private Integer isCanConvertValue;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    public ItemReportEntity() {
    }

    public ItemReportEntity(String itemCode, Integer reportId, Integer companyId, Integer orders, String itemName, Integer parent, Integer level, String uom, String weight, Integer typeItemReportId, String formula, String conditionItShouldBe, String conditionIfWrong, String typeKpi, String maxAch, String formulaYtd, String startDate, String endDate, Integer status, Integer isCanConvertValue, Integer createdBy, Date createdAt) {
        this.itemCode = itemCode;
        this.reportId = reportId;
        this.companyId = companyId;
        this.orders = orders;
        this.itemName = itemName;
        this.parent = parent;
        this.level = level;
        this.uom = uom;
        this.weight = weight;
        this.typeItemReportId = typeItemReportId;
        this.formula = formula;
        this.conditionItShouldBe = conditionItShouldBe;
        this.conditionIfWrong = conditionIfWrong;
        this.typeKpi = typeKpi;
        this.maxAch = maxAch;
        this.formulaYtd = formulaYtd;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.isCanConvertValue = isCanConvertValue;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getItemReportId() {
        return itemReportId;
    }

    public void setItemReportId(Integer itemReportId) {
        this.itemReportId = itemReportId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getTypeItemReportId() {
        return typeItemReportId;
    }

    public void setTypeItemReportId(Integer typeItemReportId) {
        this.typeItemReportId = typeItemReportId;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getConditionItShouldBe() {
        return conditionItShouldBe;
    }

    public void setConditionItShouldBe(String conditionItShouldBe) {
        this.conditionItShouldBe = conditionItShouldBe;
    }

    public String getConditionIfWrong() {
        return conditionIfWrong;
    }

    public void setConditionIfWrong(String conditionIfWrong) {
        this.conditionIfWrong = conditionIfWrong;
    }

    public String getTypeKpi() {
        return typeKpi;
    }

    public void setTypeKpi(String typeKpi) {
        this.typeKpi = typeKpi;
    }

    public String getMaxAch() {
        return maxAch;
    }

    public void setMaxAch(String maxAch) {
        this.maxAch = maxAch;
    }

    public String getFormulaYtd() {
        return formulaYtd;
    }

    public void setFormulaYtd(String formulaYtd) {
        this.formulaYtd = formulaYtd;
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

    public Integer getIsCanConvertValue() {
        return isCanConvertValue;
    }

    public void setIsCanConvertValue(Integer isCanConvertValue) {
        this.isCanConvertValue = isCanConvertValue;
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
