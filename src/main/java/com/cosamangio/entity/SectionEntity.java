package com.cosamangio.entity;

import java.util.List;

public class SectionEntity {

    private String id;
    private String code;
    private String name;
    private List<SectionItem> itemList;

    public SectionEntity() {
    }

    public SectionEntity(String id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SectionItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<SectionItem> itemList) {
        this.itemList = itemList;
    }
}
