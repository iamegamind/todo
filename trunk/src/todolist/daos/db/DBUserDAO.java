package todolist.daos.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import todolist.User;
import todolist.daos.UserDAO;


public class DBUserDAO implements UserDAO {

	private Connection conn;
	private static DBUserDAO instance;
	
	private DBUserDAO (Connection conn) {
		this.conn = conn;
	}
	
	 public static DBUserDAO getInstance(Connection conn) {
		 synchronized (DBUserDAO.class) {
			 if (instance == null) 
				 instance = new DBUserDAO(conn);
			 return instance;
		 }
	 }
	
	
	@Override
	public void create(User newInstance) {
		try {
			Statement stat = conn.createStatement();
			String sql = "INSERT INTO  users VALUES ('" 
				+ newInstance.getLogin() + "','" + newInstance.getPassword()
				+ "','" + newInstance.getName() + "')";
			stat.execute(sql);
			stat.close();			
		} catch (SQLException e) {
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}

	}

	@Override
	public void delete(User object) {
		try {
			Statement stat = conn.createStatement();
			String sql = "DELETE FROM users WHERE login = '" + object.getLogin() + "'";
			stat.execute(sql);
			stat.close();			
		} catch (SQLException e) {
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}

	}

	@Override
	public User get(String login) {
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT * FROM users WHERE login = '" + login + "'";
			ResultSet rs = stat.executeQuery(sql);
			if (!rs.next()) {
				stat.close();
				return null;
			}
			User user = new User(rs.getString("name"), rs.getString("login"),
					rs.getString("password"));
			stat.close();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public void update(User newInstance) {
		try {
			Statement stat = conn.createStatement();
			String sql = "UPDATE users SET name='" + newInstance.getName() +
				"', password='" + newInstance.getPassword() + "' WHERE login='" +
				newInstance.getLogin() + "'";
			stat.execute(sql);
			stat.close();			
		} catch (SQLException e) {
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}

	}

	@Override
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}
	}

}
