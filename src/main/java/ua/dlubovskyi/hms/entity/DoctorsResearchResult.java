package ua.dlubovskyi.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "research_results")
@Entity
public class DoctorsResearchResult {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "patients_doctors_id")
    private String patientsDoctorsId;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "date")
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientsDoctorsId() {
        return patientsDoctorsId;
    }

    public void setPatientsDoctorsId(String patientsDoctorsId) {
        this.patientsDoctorsId = patientsDoctorsId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
