
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
    "_type",
    "ViewId",
    "Result"
})
public class View implements Serializable
{

    @JsonProperty("_type")
    private String type;
    @JsonProperty("ViewId")
    private Integer viewId;
    @JsonProperty("Result")
    private List<Result> Result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -832790390313877159L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public View() {
    }

    /**
     * 
     * @param result
     * @param viewId
     * @param type
     */
    public View(String type, Integer viewId, List<Result> result) {
        super();
        this.type = type;
        this.viewId = viewId;
        this.Result = result;
    }

    @JsonProperty("_type")
    public String getType() {
        return type;
    }

    @JsonProperty("_type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("ViewId")
    public Integer getViewId() {
        return viewId;
    }

    @JsonProperty("ViewId")
    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    @JsonProperty("Result")
    public List<Result> getResult() {
        return Result;
    }

    @JsonProperty("Result")
    public void setResult(List<Result> result) {
        this.Result = result;
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
        return new ToStringBuilder(this).append("type", type).append("viewId", viewId).append("result", Result).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Result).append(viewId).append(additionalProperties).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof View) == false) {
            return false;
        }
        View rhs = ((View) other);
        return new EqualsBuilder().append(Result, rhs.Result).append(viewId, rhs.viewId).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).isEquals();
    }

}
