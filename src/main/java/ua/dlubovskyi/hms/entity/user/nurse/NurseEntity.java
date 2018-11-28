package ua.dlubovskyi.hms.entity.user.nurse;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ua.dlubovskyi.hms.entity.user.UserEntity;

/**
 * NurseEntity entity than needed for main logic of application.
 */
public class NurseEntity extends UserEntity {

    private NurseType nurseType;

    public NurseEntity() {
    }

    public NurseEntity(String userId, String fullName, NurseType nurseType) {
        super(userId, fullName);
        this.nurseType = nurseType;
    }

    public NurseType getNurseType() {
        return nurseType;
    }

    public void setNurseType(NurseType nurseType) {
        this.nurseType = nurseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NurseEntity nurseEntity = (NurseEntity) o;
        return new EqualsBuilder()
                .append(this.getUserId(), nurseEntity.getUserId())
                .append(this.getFullName(), nurseEntity.getFullName())
                .append(this.getNurseType(), nurseEntity.getNurseType())
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.getUserId())
                .append(this.getFullName())
                .append(this.getNurseType())
                .build();
    }
}