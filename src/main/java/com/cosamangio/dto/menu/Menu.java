package com.cosamangio.dto.menu;

import com.cosamangio.dto.section.Section;
import com.cosamangio.entity.SectionEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Menu implements Serializable {

    private String id;
    private String code;
    private Date lastUpdateDate;
    private String currency;
    private String locale;
    @JsonProperty("isPdf")
    private Boolean isPdf;
    private String pdfUrl;
    private String name;
    private List<Section> sections;

    public Menu(){}

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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLocale() {
        return locale;
    }

    public Boolean getPdf() {
        return isPdf;
    }

    public void setPdf(Boolean pdf) {
        isPdf = pdf;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
