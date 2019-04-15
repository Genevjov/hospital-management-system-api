package ua.dlubovskyi.hms.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * DoctorEntity entity that needed for main logic of application.
 */
public class DoctorEntity extends User {

    private String specializationId;
    private String departmentId;

    public DoctorEntity() {
    }

    public DoctorEntity(String userId, String fullName) {
        super(userId, fullName);
    }

    public DoctorEntity(String userId, String fullName, String specializationId, String departmentId) {
        super(userId, fullName);
        this.specializationId = specializationId;
        this.departmentId = departmentId;
    }

    public String getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(String specializationId) {
        this.specializationId = specializationId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoctorEntity doctorEntity = (DoctorEntity) o;
        return new EqualsBuilder()
                .append(this.getUserId(), doctorEntity.getUserId())
                .append(this.getFirstName(), doctorEntity.getFirstName())
                .append(this.getDepartmentId(), doctorEntity.getDepartmentId())
                .append(this.specializationId, doctorEntity.getSpecializationId()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.getUserId())
                .append(this.getFirstName())
                .append(this.getDepartmentId())
                .append(this.specializationId).build();
    }
}