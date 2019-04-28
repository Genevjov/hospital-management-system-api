package ua.dlubovskyi.hms.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    @Column(name = "doctor_id")
    private String doctorId;
    @Column(name = "hospitalId")
    private String hospitalId;
    @Column(name = "specialization_id")
    private String specializationId;
    @Column(name = "department_id")
    private String departmentId;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}