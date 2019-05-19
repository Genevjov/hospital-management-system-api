package ua.dlubovskyi.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PatientEntity entity than needed for main logic of application.
 */
@Entity
@Table(name = "patients")
public class PatientEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "userId")
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
