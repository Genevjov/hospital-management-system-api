package ua.dlubovskyi.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.PatientDoctorsEntity;
import ua.dlubovskyi.hms.repository.PatientDoctorsRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class PatientDoctorsService {

    private final PatientDoctorsRepository patientDoctorsRepository;
    private final EntityManager entityManager;

    @Autowired
    public PatientDoctorsService(PatientDoctorsRepository patientDoctorsRepository, EntityManager entityManager) {
        this.patientDoctorsRepository = patientDoctorsRepository;
        this.entityManager = entityManager;
    }

    public void save(PatientDoctorsEntity patientDoctorsEntity) {
        patientDoctorsRepository.save(patientDoctorsEntity);
    }

    public PatientDoctorsEntity getByDocotrAndPatientIds(String doctorId, String patientId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientDoctorsEntity> criteriaQuery = criteriaBuilder.createQuery(PatientDoctorsEntity.class);
        Root<PatientDoctorsEntity> root = criteriaQuery.from(PatientDoctorsEntity.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("patientId"), patientId),
                criteriaBuilder.equal(root.get("doctorId"), doctorId));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
