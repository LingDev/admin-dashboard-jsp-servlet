/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import model.StudentBean;
import dao.implement.StudentDaoImplement;
import dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> headerTable = new ArrayList<>();
        headerTable.add("#");
        headerTable.add("Full Name");
        headerTable.add("Date Birth");
        headerTable.add("Sex");
        headerTable.add("Class ID");
        headerTable.add("Action");
        
        List<String> bodyTable = new ArrayList<>();
        bodyTable.add("id");
        bodyTable.add("fullName");
        bodyTable.add("dateBirth");
        bodyTable.add("sex");
        bodyTable.add("classId");
        request.setAttribute("headerTable", headerTable);
                request.setAttribute("bodyTable", bodyTable);
        request.setAttribute("list", StudentDaoImplement.getAllRecords());
        RequestDispatcher view = request.getRequestDispatcher("Students.jsp");
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
