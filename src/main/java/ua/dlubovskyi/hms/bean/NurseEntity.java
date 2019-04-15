package ua.dlubovskyi.hms.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * NurseEntity entity than needed for main logic of application.
 */
public class NurseEntity extends User {

    private String departmentId;
    public NurseEntity() {
    }

    public NurseEntity(String departmentId) {
        this.departmentId = departmentId;
    }

    public NurseEntity(String userId, String fullName, String departmentId) {
        super(userId, fullName);
        this.departmentId = departmentId;
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
        if (!super.equals(o)) return false;
        NurseEntity nurseEntity = (NurseEntity) o;
        return new EqualsBuilder()
                .append(this.getUserId(), nurseEntity.getUserId())
                .append(this.getFirstName(), nurseEntity.getFirstName())
                .append(this.getDepartmentId(), nurseEntity.getDepartmentId()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.getUserId())
                .append(this.getFirstName())
                .append(this.getDepartmentId()).build();
    }
}