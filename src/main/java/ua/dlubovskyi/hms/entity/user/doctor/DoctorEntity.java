package ua.dlubovskyi.hms.entity.user.doctor;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ua.dlubovskyi.hms.entity.user.UserEntity;

/**
 * DoctorEntity entity that needed for main logic of application.
 */
public class DoctorEntity extends UserEntity {

    private String specializationId;

    public DoctorEntity() {
    }

    public DoctorEntity(String userId, String fullName) {
        super(userId, fullName);
    }

    public DoctorEntity(String userId, String fullName, String specializationId) {
        super(userId, fullName);
        this.specializationId = specializationId;
    }

    public String getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(String specializationId) {
        this.specializationId = specializationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoctorEntity doctorEntity = (DoctorEntity) o;
        return new EqualsBuilder()
                .append(this.getUserId(), doctorEntity.getUserId())
                .append(this.getFullName(), doctorEntity.getFullName())
                .append(this.specializationId, doctorEntity.getSpecializationId()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.getUserId())
                .append(this.getFullName())
                .append(this.specializationId).build();
    }
}