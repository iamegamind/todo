package todolist.daos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import todolist.daos.DAOFactory;
import todolist.daos.ToDoDAO;
import todolist.daos.UserDAO;

import oracle.jdbc.OracleDriver;


public class DBDAOFactory extends DAOFactory {

	String username = "test";
    String password = "test";
    String port = "1521";
	private Connection conn;
	
	public DBDAOFactory() {
		
	}
	
	
	@Override
	public UserDAO getUserDAO() {
		return DBUserDAO.getInstance(conn);
	}

	@Override
	public ToDoDAO getToDoDAO() {
		return DBTodoDAO.getInstance(conn);
	}


	@Override
	public void setParametrs(String param1, String param2, String param3) {
		username = param1;
		password = param2;
		port = param3;
		String url = "jdbc:oracle:thin:@//localhost:" + port + "/XE";
		OracleDriver od = new OracleDriver();
	    try {
			DriverManager.registerDriver(od);
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}
	}

}
