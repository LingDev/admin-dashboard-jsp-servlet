package servlet;

import dao.implement.UserDaoImplement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> headerTable = new ArrayList<>();
        headerTable.add("#");
        headerTable.add("User Name");
        headerTable.add("First Name");
        headerTable.add("Last Name");
        headerTable.add("Phone");
        headerTable.add("Action");

        List<String> bodyTable = new ArrayList<>();
        bodyTable.add("userId");
        bodyTable.add("userName");
        bodyTable.add("firstName");
        bodyTable.add("lastName");
        bodyTable.add("phone");
        request.setAttribute("headerTable", headerTable);
        request.setAttribute("bodyTable", bodyTable);
        request.setAttribute("list", UserDaoImplement.getAllRecords());
        RequestDispatcher view = request.getRequestDispatcher("Users.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
