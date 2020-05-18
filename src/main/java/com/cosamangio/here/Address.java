
package com.cosamangio.here;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Label",
    "Country",
    "State",
    "County",
    "City",
    "District",
    "Street",
    "HouseNumber",
    "PostalCode",
    "AdditionalData"
})
public class Address implements Serializable
{

    @JsonProperty("Label")
    private String label;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("State")
    private String state;
    @JsonProperty("County")
    private String county;
    @JsonProperty("City")
    private String city;
    @JsonProperty("District")
    private String district;
    @JsonProperty("Street")
    private String street;
    @JsonProperty("HouseNumber")
    private String houseNumber;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("AdditionalData")
    private List<AdditionalDatum> additionalData = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8380720242143450200L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param country
     * @param city
     * @param street
     * @param district
     * @param postalCode
     * @param county
     * @param houseNumber
     * @param label
     * @param state
     * @param additionalData
     */
    public Address(String label, String country, String state, String county, String city, String district, String street, String houseNumber, String postalCode, List<AdditionalDatum> additionalData) {
        super();
        this.label = label;
        this.country = country;
        this.state = state;
        this.county = county;
        this.city = city;
        this.district = district;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.additionalData = additionalData;
    }

    @JsonProperty("Label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("Label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("County")
    public String getCounty() {
        return county;
    }

    @JsonProperty("County")
    public void setCounty(String county) {
        this.county = county;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("District")
    public String getDistrict() {
        return district;
    }

    @JsonProperty("District")
    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonProperty("Street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("Street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("HouseNumber")
    public String getHouseNumber() {
        return houseNumber;
    }

    @JsonProperty("HouseNumber")
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("PostalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("AdditionalData")
    public List<AdditionalDatum> getAdditionalData() {
        return additionalData;
    }

    @JsonProperty("AdditionalData")
    public void setAdditionalData(List<AdditionalDatum> additionalData) {
        this.additionalData = additionalData;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("label", label).append("country", country).append("state", state).append("county", county).append("city", city).append("district", district).append("street", street).append("houseNumber", houseNumber).append("postalCode", postalCode).append("additionalData", additionalData).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(city).append(street).append(district).append(postalCode).append(county).append(houseNumber).append(label).append(state).append(additionalData).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address) == false) {
            return false;
        }
        Address rhs = ((Address) other);
        return new EqualsBuilder().append(country, rhs.country).append(city, rhs.city).append(street, rhs.street).append(district, rhs.district).append(postalCode, rhs.postalCode).append(county, rhs.county).append(houseNumber, rhs.houseNumber).append(label, rhs.label).append(state, rhs.state).append(additionalData, rhs.additionalData).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
