package ua.dlubovskyi.hms.entity.hospital;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.ZoneOffset;

public class LocationEntity {

    private ZoneOffset zoneOffset;
    private String locationId;
    private String country;
    private String town;
    private String address;

    public LocationEntity() {
    }

    public LocationEntity(ZoneOffset zoneOffset, String locationId, String country, String town, String address) {
        this.zoneOffset = zoneOffset;
        this.locationId = locationId;
        this.country = country;
        this.town = town;
        this.address = address;
    }

    public ZoneOffset getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationEntity location = (LocationEntity) o;
        return new EqualsBuilder()
                .append(this.getZoneOffset(), location.getZoneOffset())
                .append(this.getCountry(), location.getCountry())
                .append(this.getTown(), location.getTown())
                .append(this.getAddress(), location.getAddress())
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getZoneOffset())
                .append(this.getCountry())
                .append(this.getTown())
                .append(this.getAddress())
                .build();
    }
}