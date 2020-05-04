package com.cosamangio.dto.merchant;

import java.io.Serializable;

public class CreateMerchantRequest implements Serializable {

    private String name;
    private String shortName;
    private String vatCode;
    private String email;
    private String description;
    private String password;
    private String address;

    public CreateMerchantRequest(String name, String shortName, String vatCode, String email, String description, String password, String address) {
        this.name = name;
        this.shortName = shortName;
        this.vatCode = vatCode;
        this.email = email;
        this.description = description;
        this.password = password;
        this.address = address;
    }

    public CreateMerchantRequest() {
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
}
