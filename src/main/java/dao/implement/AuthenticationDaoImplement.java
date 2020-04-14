/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import data.BasicH2ConnectionPool;
import data.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;
import model.AuthenticatedUser;
import model.LoginForm;
import model.UserDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author vando
 */
public class AuthenticationDaoImplement implements AuthenticationDao{
    private static final AuthenticationDao instance = new AuthenticationDaoImplement();
	
	private final Logger logger = LogManager.getLogger(getClass());
	private final ConnectionPool connectionPool = BasicH2ConnectionPool.getInstance();
	
	private AuthenticationDaoImplement() {}
	
	public static AuthenticationDao getInstance() {
		return instance;
	}
	
	@Override
	public UserDetails attemptLogin(LoginForm form) {
		logger.info("Attempting to authenticate user {} at {}", form.getUserName(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy")));
		AuthenticatedUser user = null;
		try (Connection conn = connectionPool.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("select * from users where username = ? AND password = ?");
			stmt.setString(1, form.getUserName());
			stmt.setString(2, form.getPassword());
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				user = new AuthenticatedUser(rs.getString("userName"));
		} catch (SQLException e) {
			logger.error("SQL Exception caught: {}", e.getLocalizedMessage());
		}
		return user;
	}
}
