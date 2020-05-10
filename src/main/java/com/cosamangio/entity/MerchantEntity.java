package com.cosamangio.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "merchant")
public class MerchantEntity {

    @Id
    private String id;
    private String code;
    private String name;
    private String shortName;
    private String vatCode;
    private String email;
    private String validationCode;
    private Boolean validated;
    private String description;
    private String password;
    private String address;
    private Double latitude;
    private Double longitude;
    private List<String> tags;
    private List<String> allergens;
    private List<SocialEntity> socials;
    private String photoUrl;
    private Boolean weeklyMenuActive;
    private Boolean dailyMenuActive;
    private Boolean active;
    private List<MenuEntity> menus;

    public MerchantEntity() {

    }

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
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

    public List<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<String> allergens) {
        this.allergens = allergens;
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

    public void setPassword(String password) {
        this.password = password;
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

    public List<SocialEntity> getSocials() {
        return socials;
    }

    public void setSocials(List<SocialEntity> socials) {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }
}
