package com.okane.dto.approvalMatrix;

public class approvalMatrixRequest {
    private Integer approval_matrix_id;
    private Integer approval_type_id;
    private Integer operator_type_id;
    private Integer user_id;
    private Integer orders;
    private String start_date;
    private String end_date;

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

    public Integer getOperator_type_id() {
        return operator_type_id;
    }

    public void setOperator_type_id(Integer operator_type_id) {
        this.operator_type_id = operator_type_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
}
