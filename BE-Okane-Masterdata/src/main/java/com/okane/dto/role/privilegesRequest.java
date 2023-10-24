package com.okane.dto.role;

import java.util.List;

public class privilegesRequest {
    private Integer menu_id;
    private List<Integer> button_id;

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public List<Integer> getButton_id() {
        return button_id;
    }

    public void setButton_id(List<Integer> button_id) {
        this.button_id = button_id;
    }
}
