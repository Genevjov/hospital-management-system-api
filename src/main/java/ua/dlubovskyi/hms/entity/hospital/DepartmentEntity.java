package ua.dlubovskyi.hms.entity.hospital;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ua.dlubovskyi.hms.entity.user.doctor.DoctorEntity;
import ua.dlubovskyi.hms.entity.user.nurse.NurseEntity;
import ua.dlubovskyi.hms.entity.user.patient.PatientEntity;

import java.util.Set;

public class DepartmentEntity {

    private String departmentId;
    private Set<DoctorEntity> departmentDoctors;
    private Set<NurseEntity> departmentNurses;
    private Set<PatientEntity> departmentPatients;
    private Set<WardEntity> departmentWards;

    public DepartmentEntity() {
    }

    public DepartmentEntity(String departmentId, Set<DoctorEntity> departmentDoctors,
                            Set<NurseEntity> departmentNurses,
                            Set<PatientEntity> departmentPatients,
                            Set<WardEntity> departmentWards) {
        this.departmentId = departmentId;
        this.departmentDoctors = departmentDoctors;
        this.departmentNurses = departmentNurses;
        this.departmentPatients = departmentPatients;
        this.departmentWards = departmentWards;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Set<DoctorEntity> getDepartmentDoctors() {
        return departmentDoctors;
    }

    public void setDepartmentDoctors(Set<DoctorEntity> departmentDoctors) {
        this.departmentDoctors = departmentDoctors;
    }

    public Set<NurseEntity> getDepartmentNurses() {
        return departmentNurses;
    }

    public void setDepartmentNurses(Set<NurseEntity> departmentNurses) {
        this.departmentNurses = departmentNurses;
    }

    public Set<PatientEntity> getDepartmentPatients() {
        return departmentPatients;
    }

    public void setDepartmentPatients(Set<PatientEntity> departmentPatients) {
        this.departmentPatients = departmentPatients;
    }

    public Set<WardEntity> getDepartmentWards() {
        return departmentWards;
    }

    public void setDepartmentWards(Set<WardEntity> departmentWards) {
        this.departmentWards = departmentWards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return new EqualsBuilder()
                .append(getDepartmentId(), that.getDepartmentId())
                .append(getDepartmentDoctors(), that.getDepartmentDoctors())
                .append(getDepartmentNurses(), that.getDepartmentNurses())
                .append(getDepartmentPatients(), that.getDepartmentPatients())
                .append(getDepartmentWards(), that.getDepartmentWards())
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getDepartmentId())
                .append(this.getDepartmentDoctors())
                .append(this.getDepartmentNurses())
                .append(this.getDepartmentPatients())
                .append(getDepartmentWards())
                .build();
    }
}