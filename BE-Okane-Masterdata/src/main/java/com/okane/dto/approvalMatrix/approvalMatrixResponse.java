package com.okane.dto.approvalMatrix;

public class approvalMatrixResponse {
    private Integer approval_matrix_id;
    private Integer approval_type_id;
    private String approval_type_name;
    private Integer operator_type_id;
    private String operator_type_name;
    private Integer user_id;
    private String fullname;
    private Integer orders;
    private String start_date;
    private String end_date;
    private String status;
    private String created;
    private String updated;

    public approvalMatrixResponse(Integer approval_matrix_id, Integer approval_type_id, String approval_type_name, Integer operator_type_id, String operator_type_name, Integer user_id, String fullname, Integer orders, String start_date, String end_date, String status, String created, String updated) {
        this.approval_matrix_id = approval_matrix_id;
        this.approval_type_id = approval_type_id;
        this.approval_type_name = approval_type_name;
        this.operator_type_id = operator_type_id;
        this.operator_type_name = operator_type_name;
        this.user_id = user_id;
        this.fullname = fullname;
        this.orders = orders;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public Integer getApproval_matrix_id() {
        return approval_matrix_id;
    }

    public void setApproval_matrix_id(Integer approval_matrix_id) {
        this.approval_matrix_id = approval_matrix_id;
    }

    public Integer getApproval_type_id() {
        return approval_type_id;
    }

    public void setApproval_type_id(Integer approval_type_id) {
        this.approval_type_id = approval_type_id;
    }

    public String getApproval_type_name() {
        return approval_type_name;
    }

    public void setApproval_type_name(String approval_type_name) {
        this.approval_type_name = approval_type_name;
    }

    public Integer getOperator_type_id() {
        return operator_type_id;
    }

    public void setOperator_type_id(Integer operator_type_id) {
        this.operator_type_id = operator_type_id;
    }

    public String getOperator_type_name() {
        return operator_type_name;
    }

    public void setOperator_type_name(String operator_type_name) {
        this.operator_type_name = operator_type_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
