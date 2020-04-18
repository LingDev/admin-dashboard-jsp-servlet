package dao.implement;

import java.util.Objects;

/**
 *
 * @author vando
 */
public class LoginDaoImplement {

    private String userName;
    private String password;

    public LoginDaoImplement(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, userName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LoginDaoImplement)) {
            return false;
        }
        LoginDaoImplement other = (LoginDaoImplement) obj;
        return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
    }

}
