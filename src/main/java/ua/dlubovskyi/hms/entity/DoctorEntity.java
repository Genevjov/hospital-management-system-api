package ua.dlubovskyi.hms.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    @Column(name = "doctor_id")
    private String doctorId;
    @Column(name = "specialization_name")
    private String specializationName;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }


    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}