package com.okane.dto.role;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class roleRequest {

    private Integer role_id;
    private String role_name;
    private String start_date;
    private String end_date;

    private List<privilegesRequest> privileges;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
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

    public List<privilegesRequest> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<privilegesRequest> privileges) {
        this.privileges = privileges;
    }
}
