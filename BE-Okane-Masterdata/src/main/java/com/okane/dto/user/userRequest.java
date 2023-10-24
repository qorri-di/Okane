package com.okane.dto.user;

import javax.validation.constraints.*;
import java.util.List;

public class userRequest{

    private Integer user_id;

    @NotNull
    private Integer role_id;

    @NotBlank
    private String email;

    @NotBlank
    private String fullname;

    @NotBlank
    private String start_date;

    @NotBlank
    private String end_date;

    private List<Integer> company;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public List<Integer> getCompany() {
        return company;
    }

    public void setCompany(List<Integer> company) {
        this.company = company;
    }

}
