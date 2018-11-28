package ua.dlubovskyi.hms.entity.user.patient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ua.dlubovskyi.hms.entity.user.UserEntity;
import ua.dlubovskyi.hms.entity.user.doctor.DoctorEntity;

/**
 * PatientEntity entity than needed for main logic of application.
 */
public class PatientEntity extends UserEntity {

    private PatientType patientType;
    private DoctorEntity attendingDoctor;

    public PatientEntity() {
    }

    public PatientEntity(PatientType patientType, DoctorEntity attendingDoctor) {
        this.patientType = patientType;
        this.attendingDoctor = attendingDoctor;
    }

    public PatientEntity(String userId, String fullName, PatientType patientType, DoctorEntity attendingDoctor) {
        super(userId, fullName);
        this.patientType = patientType;
        this.attendingDoctor = attendingDoctor;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }

    public DoctorEntity getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setAttendingDoctor(DoctorEntity attendingDoctor) {
        this.attendingDoctor = attendingDoctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PatientEntity patientEntity = (PatientEntity) o;
        return new EqualsBuilder()
                .append(this.getUserId(), patientEntity.getUserId())
                .append(this.getFullName(), patientEntity.getFullName())
                .append(this.getPatientType(), patientEntity.getPatientType())
                .append(this.getAttendingDoctor(), patientEntity.getAttendingDoctor()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getUserId())
                .append(this.getFullName())
                .append(this.getPatientType())
                .append(this.getAttendingDoctor()).build();
    }
}