<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="student-dashboard">
    <h1>Student Dashboard</h1>
    <div class="form-section">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Full Name</th>
                    <th>Date Birth</th>
                    <th>Sex</th>
                    <th>Class Id</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td><c:out value="${student.id}" /></td>
                        <td><c:out value="${student.fullName}" /></td>
                        <td><c:out value="${student.dateBirth}" /></td>
                        <td><c:out value="${student.sex}" /></td>
                        <td><c:out value="${student.classId}" /></td>
                        <td><a class="btn btn-primary" role="button"
                               href="StudentServlet.do?action=edit&studentId=<c:out value="${student.id}"/>">Update</a>
                            <a class="btn btn-primary" role="button" style="padding-left:5px;"
                               href="StudentServlet.do?action=delete&studentId=<c:out value="${student.id }"/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%@include file="parts/StudentInsertForm.jsp" %>
    </div>
</div>


