package ua.dlubovskyi.hms.entity.user;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Base user entity for hierarchy.
 */
public class UserEntity {

    private String userId;
    private String fullName;

    public UserEntity() {
    }

    public UserEntity(String userId, String fullName) {
        this.userId = userId;
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return new EqualsBuilder()
                .append(this.getUserId(), userEntity.getUserId())
                .append(this.getFullName(), userEntity.getFullName()).build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.getUserId())
                .append(this.fullName).build();
    }
}