
package dao.implement;

import data.ConnectionPoolImplement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.AuthenticatedUserBean;

/**
 *
 * @author vando
 */
public class AuthenticationDaoImplement {
     
 

    public AuthenticationDaoImplement( )   {
          
    }
    
    public static AuthenticatedUserBean attemptLogin(LoginDaoImplement form){
         AuthenticatedUserBean authenticatedUserBean = null;
         try(Connection connection = ConnectionPoolImplement.getConnection() ){
             PreparedStatement ps = connection.prepareStatement("SELECT USERNAME, USERS.USERID,ROLENAME FROM USERS, USER_ROLE, ROLE WHERE USERNAME = ? AND PW = ? AND USERS.USERID = USER_ROLE.USERID AND USER_ROLE.ROLEID = ROLE.ROLEID ");
             ps.setString(1, form.getUserName());
             ps.setString(2, form.getPassword());
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 authenticatedUserBean = new AuthenticatedUserBean(rs.getString("userName"), rs.getInt("userId"), rs.getString("roleName"));
             }
         }
         catch(Exception e){
             e.printStackTrace();
         }
         return authenticatedUserBean;
    }
    
}
