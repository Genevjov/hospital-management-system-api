package ua.dlubovskyi.hms.entity.hospital;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Set;

public class SubsidiaryEntity {

    private String subsidiaryId;
    private LocationEntity subsidiaryLocation;
    private Set<DepartmentEntity> departments;

    public SubsidiaryEntity() {
    }

    public SubsidiaryEntity(String subsidiaryId, LocationEntity subsidiaryLocation, Set<DepartmentEntity> departments) {
        this.subsidiaryId = subsidiaryId;
        this.subsidiaryLocation = subsidiaryLocation;
        this.departments = departments;
    }

    public String getSubsidiaryId() {
        return subsidiaryId;
    }

    public void setSubsidiaryId(String subsidiaryId) {
        this.subsidiaryId = subsidiaryId;
    }

    public LocationEntity getSubsidiaryLocation() {
        return subsidiaryLocation;
    }

    public void setSubsidiaryLocation(LocationEntity subsidiaryLocation) {
        this.subsidiaryLocation = subsidiaryLocation;
    }

    public Set<DepartmentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<DepartmentEntity> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubsidiaryEntity subsidiaryEntity = (SubsidiaryEntity) o;
        return new EqualsBuilder()
                .append(this.getSubsidiaryId(), subsidiaryEntity.getSubsidiaryId())
                .append(this.getSubsidiaryLocation(), subsidiaryEntity.getSubsidiaryLocation())
                .append(this.getDepartments(), getDepartments())
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getSubsidiaryId())
                .append(this.getSubsidiaryLocation())
                .append(this.getDepartments())
                .build();
    }
}