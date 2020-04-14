/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.linhdoan.mavenproject3.StudentBean;
import com.linhdoan.mavenproject3.StudentDaoImplement;
import dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vando
 */
public class StudentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if (StudentDaoImplement.getAllRecords().isEmpty()) {
                response.sendRedirect("/Home.jsp");
            }
            request.setAttribute("students", StudentDaoImplement.getAllRecords());
            RequestDispatcher view = request.getRequestDispatcher("/Students.jsp");
            view.forward(request, response);
            /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentInsertServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentInsertServlet atadasdasdas " + request.getContextPath() + "</h1>");
            String fullName = request.getParameter("txtFullName");
            int sex = Integer.parseInt(request.getParameter("txtSex"));
            //parse date from form to mysql-format action
            java.util.Date db = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtDateBirth"));
            java.sql.Date dateBirth = new java.sql.Date(db.getTime());
            String classId = request.getParameter("txtClassId");
            StudentBean studentBean = new StudentBean(fullName, dateBirth, sex, classId);
            if (StudentDaoImplement.insertStudent(studentBean) == true) {
                out.print("<h1>Servlet StudentInsertServlet atadasdasdas </h1>");
            } else {
                out.print("<h1>loi con e no rois </h1> ");
            }
            out.println("</body>");
            out.println("</html>"); */
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(StudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
