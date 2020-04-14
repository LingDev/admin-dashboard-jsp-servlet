/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implement;

import dao.UserDao;
import data.ConnectionPooll;
import java.sql.*;
import model.UserBean;

/**
 *
 * @author vando
 */
public class UserDaoImplement implements UserDao {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static boolean login(UserBean userBean) throws ClassNotFoundException {
        boolean canLogin = false;
        try {
            currentCon = ConnectionPooll.getConnection();
            PreparedStatement ps = currentCon.prepareStatement("SELECT * FROM USERS WHERE userName = ? AND pw = ?");
            ps.setString(1, userBean.getUserName());
            ps.setString(2, userBean.getPw());
            rs = ps.executeQuery();
            if (rs.next()) {
                canLogin = true;
            }
            ps.close();
            currentCon.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return canLogin;
    }

    public static boolean register(UserBean userBean) throws ClassNotFoundException, SQLException {
        boolean registStatus = false;
        PreparedStatement ps;
        try {
            currentCon = ConnectionPooll.getConnection();
            ps = currentCon.prepareStatement("SELECT * FROM USERS WHERE userName = ?");
            ps.setString(1, userBean.getUserName());
            rs = ps.executeQuery();
            if (!rs.next()) {
                ps.clearBatch();
                ps.clearParameters();
                ps = currentCon.prepareStatement("INSERT INTO USERS (userName, pw, firstName, lastName, phone) VALUES (?,?,?,?,?)");
                ps.setString(1, userBean.getUserName());
                ps.setString(2, userBean.getPw());
                ps.setString(3, userBean.getFirstName());
                ps.setString(4, userBean.getLastName());
                ps.setString(5, userBean.getPhone());
                if (ps.executeUpdate() != 0) {
                    registStatus = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registStatus;
    }

    public static UserBean getDetails(UserBean uBean) throws ClassNotFoundException {
        UserBean userBean = new UserBean(uBean.getUserName(), uBean.getPw());
        try {
            currentCon = ConnectionPooll.getConnection();
            PreparedStatement ps = currentCon.prepareStatement("SELECT * FROM USERS WHERE userName = ?");
            ps.setString(1, userBean.getUserName());
            rs = ps.executeQuery();
            userBean.setFirstName(rs.getString("firstName"));
            userBean.setLastName(rs.getString("lastName"));
            userBean.setPhone(rs.getString("phone"));
            userBean.setPw(rs.getString("pw"));
            userBean.setUserId(rs.getString("userId"));
            userBean.setUserName(rs.getString("userName"));
            currentCon.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBean;
    }

}
