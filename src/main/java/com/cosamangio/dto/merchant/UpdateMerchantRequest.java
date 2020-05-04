package com.cosamangio.dto.merchant;

import java.io.Serializable;
import java.util.List;

public class UpdateMerchantRequest implements Serializable {

    private long id;
    private String code;
    private String name;
    private String shortName;
    private String vatCode;
    private String email;
    private String description;
    private String password;
    private String address;
    private List<String> tags;
    private Boolean weeklyMenuActive;
    private Boolean dailyMenuActive;

    public UpdateMerchantRequest() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getVatCode() {
        return vatCode;
    }

    public void setVatCode(String vatCode) {
        this.vatCode = vatCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Boolean getWeeklyMenuActive() {
        return weeklyMenuActive;
    }

    public void setWeeklyMenuActive(Boolean weeklyMenuActive) {
        this.weeklyMenuActive = weeklyMenuActive;
    }

    public Boolean getDailyMenuActive() {
        return dailyMenuActive;
    }

    public void setDailyMenuActive(Boolean dailyMenuActive) {
        this.dailyMenuActive = dailyMenuActive;
    }
}
