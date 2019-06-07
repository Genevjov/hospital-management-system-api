package ua.dlubovskyi.hms.service.impl;

import org.springframework.stereotype.Service;
import ua.dlubovskyi.hms.entity.Department;
import ua.dlubovskyi.hms.repository.DepartmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private EntityManager entityManager;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> findByHospId(String id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
        Root<Department> root = criteriaQuery.from(Department.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("hospitalId"),id));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
