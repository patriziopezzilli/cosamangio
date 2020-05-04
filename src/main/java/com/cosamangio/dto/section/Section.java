package com.cosamangio.dto.section;

import com.cosamangio.dto.item.Item;
import com.cosamangio.entity.SectionItem;

import java.io.Serializable;
import java.util.List;

public class Section implements Serializable {

    private String id;
    private String code;
    private String name;
    private List<Item> itemList;

    public Section(){

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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
