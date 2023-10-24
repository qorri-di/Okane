package com.okane.dto;

import java.util.List;

public class responseList {
    private String status;
    private List<?> data;
    private String message;

    public responseList(String status, List<?> data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getData() {
        return (List<?>) data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
