
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
    "Street",
    "HouseNumber"
})
public class MatchQuality implements Serializable
{

    @JsonProperty("Street")
    private List<Integer> street = null;
    @JsonProperty("HouseNumber")
    private Integer houseNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8711277441216833892L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MatchQuality() {
    }

    /**
     * 
     * @param street
     * @param houseNumber
     */
    public MatchQuality(List<Integer> street, Integer houseNumber) {
        super();
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @JsonProperty("Street")
    public List<Integer> getStreet() {
        return street;
    }

    @JsonProperty("Street")
    public void setStreet(List<Integer> street) {
        this.street = street;
    }

    @JsonProperty("HouseNumber")
    public Integer getHouseNumber() {
        return houseNumber;
    }

    @JsonProperty("HouseNumber")
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
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
        return new ToStringBuilder(this).append("street", street).append("houseNumber", houseNumber).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(houseNumber).append(additionalProperties).append(street).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MatchQuality) == false) {
            return false;
        }
        MatchQuality rhs = ((MatchQuality) other);
        return new EqualsBuilder().append(houseNumber, rhs.houseNumber).append(additionalProperties, rhs.additionalProperties).append(street, rhs.street).isEquals();
    }

}
