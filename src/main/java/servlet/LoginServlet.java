package servlet;

import dao.implement.UserDaoImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserBean;

/**
 *
 * @author vando
 */
public class LoginServlet extends HttpServlet {

    private static String WELCMPG = "/welcome.jsp";
    private static String HOME = "/Home.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserBean userBean = new UserBean(request.getParameter("userName").toString(), request.getParameter("password").toString());
        try {
            if (UserDaoImplement.login(userBean)) {
                UserBean user = UserDaoImplement.getDetails(userBean);
                HttpSession session = request.getSession();
                Cookie loginCookie = new Cookie("userName", userBean.getUserName());
                loginCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);
                session.setMaxInactiveInterval(12000);
                session.setAttribute("userName", user.getUserName());
                session.setAttribute("fullName", user.getFirstName() + " " + user.getLastName());
                //load welcome page with session data
                //RequestDispatcher view = request.getRequestDispatcher(HOME);
                response.sendRedirect(HOME);
                //view.forward(request, response);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Either user name or password is wrong.</font>");
                rd.include(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
