package com.linhdoan.mavenproject3;

import java.text.*;
import java.util.*;
import java.sql.*;
import com.linhdoan.mavenproject3.StudentBean;
import dao.StudentDao;
import data.ConnectionPooll;
import java.util.Date;

/**
 *
 * @author vando
 */
public class StudentDaoImplement {

    static ResultSet rs = null;

    protected static Connection getConnection()
            throws SQLException, ClassNotFoundException {
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3307/";
        // Database name to access 
        String dbName = "studentmng";
        String dbUsername = "root";
        String dbPassword = "Linh@12345";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
    public static boolean insertStudent(StudentBean studentBean) {
        try {
            Connection connection = ConnectionPooll.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO STUDENT(fullName,dateBirth,sex,classId) values(?,?,?,?)");
            ps.setString(1, studentBean.getFullName());
            ps.setDate(2, studentBean.getDateBirth());
            ps.setInt(3, studentBean.getSex());
            ps.setString(4, studentBean.getClassId());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean updateStudent(StudentBean studentBean) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE STUDENT SET fullName = ? , dateBirth = ? , sex = ? WHERE id = ?");
            ps.setString(1, studentBean.getFullName());
            ps.setDate(2, studentBean.getDateBirth());
            ps.setInt(3, studentBean.getSex());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean deleteStudent(StudentBean studentBean) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE STUDENT WHERE id = ? ");
            ps.setInt(1, studentBean.getId());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<StudentBean> getAllRecords() {
        List<StudentBean> list = new ArrayList<StudentBean>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentBean u = new StudentBean();
                u.setId(rs.getInt("id"));
                u.setFullName(rs.getString("fullName"));
                u.setDateBirth(rs.getDate("dateBirth"));
                u.setSex(rs.getInt("sex"));
                u.setClassId(rs.getString("classId"));
                list.add(u);
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
 
}
