package ua.dlubovskyi.hms.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * PatientEntity entity than needed for main logic of application.
 */
public class PatientEntity extends User {

    private String doctorId;
    private String departmentId;

    public PatientEntity() {
    }

    public PatientEntity(String doctorId, String departmentId) {
        this.doctorId = doctorId;
        this.departmentId = departmentId;
    }

    public PatientEntity(String userId, String fullName, String doctorId, String departmentId) {
        super(userId, fullName);
        this.doctorId = doctorId;
        this.departmentId = departmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
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
        PatientEntity patientEntity = (PatientEntity) o;
        return new EqualsBuilder()
                .append(this.getUserId(), patientEntity.getUserId())
                .append(this.getFirstName(), patientEntity.getFirstName())
                .append(this.getDepartmentId(), patientEntity.getDepartmentId())
                .append(this.doctorId, patientEntity.getDoctorId()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getUserId())
                .append(this.getFirstName())
                .append(this.getDepartmentId())
                .append(this.getDoctorId()).build();
    }
}
