package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoginServiceImplement;

/**
 *
 * @author vando
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginServiceImplement service;
    private ObjectMapper mapper;
     

    @Override
    public void init() throws ServletException {
        service = new LoginServiceImplement();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("application/json");
        String token = service.attemptAuthentication(request, response);
        if (token == null) {
            response.getOutputStream().write(mapper.writeValueAsBytes(Collections.singletonMap("message", "Invalid Credentials")));
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        response.getOutputStream().write(mapper.writeValueAsBytes(Collections.singletonMap("token", "Bearer " + token)));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
