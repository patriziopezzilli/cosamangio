
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
    "LocationId",
    "LocationType",
    "DisplayPosition",
    "NavigationPosition",
    "MapView",
    "Address"
})
public class Location implements Serializable
{

    @JsonProperty("LocationId")
    private String locationId;
    @JsonProperty("LocationType")
    private String locationType;
    @JsonProperty("DisplayPosition")
    private DisplayPosition displayPosition;
    @JsonProperty("NavigationPosition")
    private List<NavigationPosition> navigationPosition = null;
    @JsonProperty("MapView")
    private MapView mapView;
    @JsonProperty("Address")
    private Address address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8660558775360751580L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param mapView
     * @param address
     * @param locationId
     * @param locationType
     * @param navigationPosition
     * @param displayPosition
     */
    public Location(String locationId, String locationType, DisplayPosition displayPosition, List<NavigationPosition> navigationPosition, MapView mapView, Address address) {
        super();
        this.locationId = locationId;
        this.locationType = locationType;
        this.displayPosition = displayPosition;
        this.navigationPosition = navigationPosition;
        this.mapView = mapView;
        this.address = address;
    }

    @JsonProperty("LocationId")
    public String getLocationId() {
        return locationId;
    }

    @JsonProperty("LocationId")
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @JsonProperty("LocationType")
    public String getLocationType() {
        return locationType;
    }

    @JsonProperty("LocationType")
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    @JsonProperty("DisplayPosition")
    public DisplayPosition getDisplayPosition() {
        return displayPosition;
    }

    @JsonProperty("DisplayPosition")
    public void setDisplayPosition(DisplayPosition displayPosition) {
        this.displayPosition = displayPosition;
    }

    @JsonProperty("NavigationPosition")
    public List<NavigationPosition> getNavigationPosition() {
        return navigationPosition;
    }

    @JsonProperty("NavigationPosition")
    public void setNavigationPosition(List<NavigationPosition> navigationPosition) {
        this.navigationPosition = navigationPosition;
    }

    @JsonProperty("MapView")
    public MapView getMapView() {
        return mapView;
    }

    @JsonProperty("MapView")
    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    @JsonProperty("Address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(Address address) {
        this.address = address;
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
        return new ToStringBuilder(this).append("locationId", locationId).append("locationType", locationType).append("displayPosition", displayPosition).append("navigationPosition", navigationPosition).append("mapView", mapView).append("address", address).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mapView).append(address).append(locationId).append(locationType).append(additionalProperties).append(navigationPosition).append(displayPosition).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Location) == false) {
            return false;
        }
        Location rhs = ((Location) other);
        return new EqualsBuilder().append(mapView, rhs.mapView).append(address, rhs.address).append(locationId, rhs.locationId).append(locationType, rhs.locationType).append(additionalProperties, rhs.additionalProperties).append(navigationPosition, rhs.navigationPosition).append(displayPosition, rhs.displayPosition).isEquals();
    }

}
