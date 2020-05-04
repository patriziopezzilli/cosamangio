package com.cosamangio.dto.merchant;

import com.cosamangio.dto.menu.Menu;
import com.cosamangio.dto.social.Social;
import com.cosamangio.entity.MenuEntity;
import com.cosamangio.entity.SocialEntity;

import java.io.Serializable;
import java.util.List;

public class Merchant implements Serializable {

    private String id;
    private String code;
    private String name;
    private String shortName;
    private String vatCode;
    private String email;
    private String validationCode;
    private Boolean validated;
    private String description;
    private String address;
    private Double latitude;
    private Double longitude;
    private List<String> tags;
    private List<Social> socials;
    private String photoUrl;
    private Boolean weeklyMenuActive;
    private Boolean dailyMenuActive;
    private List<Menu> menus;

    public Merchant() {

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

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Social> getSocials() {
        return socials;
    }

    public void setSocials(List<Social> socials) {
        this.socials = socials;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
