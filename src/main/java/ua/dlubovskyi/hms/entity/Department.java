package ua.dlubovskyi.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "department_name")
    private String name;
    @Column(name = "hospital_id")
    private String hospitalId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
}
