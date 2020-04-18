
package service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.implement.AuthenticationDaoImplement;
import dao.implement.LoginDaoImplement;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AuthenticatedUserBean;

/**
 *
 * @author vando
 */
public class LoginServiceImplement {
         
        
        private final ObjectMapper mapper = new ObjectMapper();
        public String attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		TokenServiceImplement tokenServiceImplement = new TokenServiceImplement();
		LoginDaoImplement form = null;
//		try {
//			form = mapper.readValue(request.getInputStream(), LoginDaoImplement.class);
//		} catch (JsonParseException e) {
//                    // TODO Auto-generated catch block
//
//		} catch (JsonMappingException e) {
//                    // TODO Auto-generated catch block
//
//		} catch (IOException e) {
//                    // TODO Auto-generated catch block
//
//		}
		form = new LoginDaoImplement(request.getParameter("userName"), request.getParameter("password"));
//		final LoginForm form = new LoginForm(request.getParameter("username"), request.getParameter("password"));
		final AuthenticatedUserBean authenticatedUserBean = AuthenticationDaoImplement.attemptLogin(form);
		if (authenticatedUserBean != null) {
			return tokenServiceImplement.generateToken(authenticatedUserBean);
		}
		return null;
	}
        
}
