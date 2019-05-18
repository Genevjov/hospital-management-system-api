package ua.dlubovskyi.hms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "hms_api_db")
public class User {

    @Id
    @Column(name = "id")
    private String userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "profile_type")
    private String profileType;
    @Column(name = "hospital_id")
    private String hospitalId;
    @Column(name = "department_id")
    private String departmentId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
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
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(countryCode, user.countryCode) &&
                Objects.equals(profileType, user.profileType) &&
                Objects.equals(hospitalId, user.hospitalId) &&
                Objects.equals(departmentId, user.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, secondName, phone, email, password, countryCode, profileType, hospitalId, departmentId);
    }
}