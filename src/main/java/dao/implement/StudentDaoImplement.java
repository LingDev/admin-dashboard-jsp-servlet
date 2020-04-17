package dao.implement;

import java.text.*;
import java.util.*;
import java.sql.*;
import model.StudentBean;
import dao.StudentDao;
import data.ConnectionPooll;
import java.util.Date;

/**
 *
 * @author vando
 */
public class StudentDaoImplement {

    public static boolean insertStudent(StudentBean studentBean) {
        try ( Connection currentCon = ConnectionPooll.getConnection()) {
            PreparedStatement ps = currentCon.prepareStatement("INSERT INTO STUDENT(fullName,dateBirth,sex,classId) values(?,?,?,?)");
            ps.setString(1, studentBean.getFullName());
            ps.setDate(2, studentBean.getDateBirth());
            ps.setInt(3, studentBean.getSex());
            ps.setString(4, studentBean.getClassId());
            ps.executeUpdate();
            currentCon.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean updateStudent(StudentBean studentBean) {
        try ( Connection currentCon = ConnectionPooll.getConnection()) {
            PreparedStatement ps = currentCon.prepareStatement("UPDATE STUDENT SET fullName = ? , dateBirth = ? , sex = ? WHERE id = ?");
            ps.setString(1, studentBean.getFullName());
            ps.setDate(2, studentBean.getDateBirth());
            ps.setInt(3, studentBean.getSex());
            ps.executeUpdate();
            currentCon.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean deleteStudent(StudentBean studentBean) {
        try ( Connection currentCon = ConnectionPooll.getConnection()) {
            PreparedStatement ps = currentCon.prepareStatement("DELETE STUDENT WHERE id = ? ");
            ps.setInt(1, studentBean.getId());
            ps.executeUpdate();
            currentCon.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<StudentBean> getAllRecords() {
        List<StudentBean> list = new ArrayList<StudentBean>();
        try ( Connection currentCon = ConnectionPooll.getConnection()) {

            PreparedStatement ps = currentCon.prepareStatement("SELECT * FROM STUDENT");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentBean u = new StudentBean();
                u.setId(rs.getInt("id"));
                u.setFullName(rs.getString("fullName"));
                u.setDateBirth(rs.getDate("dateBirth"));
                u.setSex(rs.getInt("sex"));
                u.setClassId(rs.getString("classId"));
                list.add(u);
                System.out.println(u.getId());
            }
            ps.close();
            currentCon.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}
