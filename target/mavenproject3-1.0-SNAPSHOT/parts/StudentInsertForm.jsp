<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%--
    // assumes database name is the same as username
    try {
        java.sql.Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.
                getConnection("jdbc:mysql://localhost:3307/studentmng", "root", "Linh@12345");
        out.println("database successfully opened.");
    } catch (SQLException e) {
        out.println("SQLException caught: " + e.getMessage());
    }
--%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<sql:setDataSource
    var="myDS"
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3307/studentmng"
    user="root" password="Linh@12345"
    />

<sql:query var="listClass"   dataSource="${myDS}">
    SELECT * FROM class;
</sql:query>
<form class="form-h" name="studentForm" method="POST" action="StudentInsertServlet">
    <h3 style="text-align: center;">Them Sinh Vien</h3>
    <!-- Text input-->
    <div class="form-group">
        <label class="col-md-4 control-label" for="txtFullName">Ho va ten : </label>  
        <div class="col">
            <input id="txtFullName" name="txtFullName" type="text" placeholder="Ho va ten ...." class="form-control input-md">
            <span class="help-block"> </span>  
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 control-label" for="txtDateBirth">Ngay sinh : </label>  
        <div class="col ">
            <input id="txtDateBirth" name="txtDateBirth" type="date" placeholder="" class="form-control input-md">
            <span class="help-block"> </span>  
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 control-label" for="txtSex">Gioi tinh : </label>
        <div class="col "> 
            <label class="radio-inline" for="txtSex-0">
                <input type="radio" name="txtSex" id="txtSex-0" value="0" checked="checked">
                Nam
            </label> 
            <label class="radio-inline" for="txtSex-1">
                <input type="radio" name="txtSex" id="txtSex-1" value="1">
                Nu
            </label>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-4 control-label" for="txtClassId">Lop : </label>
        <div class="col ">
            <select id="txtLop" name="txtClassId" class="form-control">
                <c:forEach var="select_item" items="${listClass.rows}"  >
                    <option value="<c:out value='${select_item.classId}' />"><c:out value="${select_item.classid} - ${select_item.className}  " ></c:out></option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col ">
            <button id="submitbutton" type="submit" name="submitbutton" class="btn btn-primary">Them</button>
            <button id="clearbutton" type="button" name="clearbutton" class="btn btn-danger">Clear</button>
        </div>
    </div>
</form>