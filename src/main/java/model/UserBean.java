 
package model;

/**
 *
 * @author vando
 */
public class UserBean {
    private String userId;
    private String userName;
    private String pw;
    private String firstName;
    private String lastName;
    private String phone;

    public UserBean(String userId, String userName, String pw, String firstName, String lastName, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.pw = pw;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public UserBean(String userName, String pw, String firstName, String lastName, String phone) {
        this.userName = userName;
        this.pw = pw;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public UserBean(String userName, String pw) {
        this.userName = userName;
        this.pw = pw;
    }

    public UserBean() {
         
    }
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
