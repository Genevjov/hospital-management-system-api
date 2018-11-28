package ua.dlubovskyi.hms.entity.hospital;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ua.dlubovskyi.hms.entity.user.patient.PatientEntity;

import java.util.Set;

public class WardEntity {

    private String wardId;
    private int wardCapacity;
    private Set<PatientEntity> wardPatientsSet;

    public WardEntity() {
    }

    public WardEntity(String wardId, int wardCapacity, Set<PatientEntity> wardPatientsSet) {
        this.wardId = wardId;
        this.wardCapacity = wardCapacity;
        this.wardPatientsSet = wardPatientsSet;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public int getWardCapacity() {
        return wardCapacity;
    }

    public void setWardCapacity(int wardCapacity) {
        this.wardCapacity = wardCapacity;
    }

    public Set<PatientEntity> getWardPatientsSet() {
        return wardPatientsSet;
    }

    public void setWardPatientsSet(Set<PatientEntity> wardPatientsSet) {
        this.wardPatientsSet = wardPatientsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WardEntity wardEntity = (WardEntity) o;
        return new EqualsBuilder()
                .append(this.getWardId(), wardEntity.getWardId())
                .append(this.getWardCapacity(), wardEntity.getWardCapacity())
                .append(this.getWardPatientsSet(), wardEntity.getWardPatientsSet())
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getWardId())
                .append(this.getWardCapacity())
                .append(this.getWardPatientsSet())
                .build();
    }
}