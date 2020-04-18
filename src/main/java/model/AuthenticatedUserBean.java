package model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author vando
 */
public class AuthenticatedUserBean {
 

    private String userName;
    private int userId;
    private String roles;

    public AuthenticatedUserBean(String userName, int userId, String roles) {
        this.userName = userName;
        this.userId = userId;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roles, userName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuthenticatedUserBean other = (AuthenticatedUserBean) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuthenticatedUserBean{" + "userName=" + userName + ", userId=" + userId + ", roles=" + roles + '}';
    }
    
}
