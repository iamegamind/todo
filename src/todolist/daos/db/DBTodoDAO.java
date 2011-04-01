package todolist.daos.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import todolist.ToDo;
import todolist.User;
import todolist.daos.ToDoDAO;


public class DBTodoDAO implements ToDoDAO {

	private Connection conn;
	private static DBTodoDAO instance;
	
	private DBTodoDAO (Connection conn) {
		this.conn = conn;
	}
	
	 public static DBTodoDAO getInstance(Connection conn) {
		 synchronized (DBTodoDAO.class) {
			 if (instance == null) 
				 instance = new DBTodoDAO(conn);
			 return instance;
		 }
	 }	
	
	@Override
	public void create(ToDo newInstance) {
		try {
			Statement stat = conn.createStatement();
			String sql = "INSERT INTO todos VALUES ('"
				+ newInstance.getName() + "','" + newInstance.getUser()
				+ "','" + newInstance.getDescription() 
				+ "','" + newInstance.getPriority()
				+ "','" + newInstance.getDate()
				+ "','" + newInstance.isDone()
				+ "')";
			stat.execute(sql);
			stat.close();			
		} catch (SQLException e) {
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}
	}

	@Override
	public void delete(ToDo object) {
		try {
			Statement stat = conn.createStatement();
			String sql = "DELETE FROM todos WHERE login = '" + object.getUser() + "'" +
					"AND name='" + object.getName() + "'";
			stat.execute(sql);
			stat.close();			
		} catch (SQLException e) {
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}
	}

	@Override
	public ArrayList<ToDo> get(User user) {
		try {
			Statement stat = conn.createStatement();
			String sql = "SELECT * FROM todos WHERE login = '" + user.getLogin() + "'";
			ResultSet rs = stat.executeQuery(sql);
			ArrayList<ToDo> result = new ArrayList<ToDo>();
			while (rs.next()) {
				ToDo todo = new ToDo(rs.getString("login"), 
						rs.getString("date"),
						rs.getString("name"),
						rs.getString("priority"),
						rs.getString("description"),
						Boolean.valueOf(rs.getString("done")));
				result.add(todo);
			}
			stat.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed: JDBC Driver Error: " + e.getMessage());
		}
		return null;
	}

	@Override
	public void update(ToDo newInstance) {
		try {
			Statement stat = conn.createStatement();
			String sql = "UPDATE todos SET " +
					"description='" + newInstance.getDescription() +
					"', priority='" + newInstance.getPriority() +
					"', date='" + newInstance.getDate() +
					"', done='" + newInstance.isDone()
					+ "' WHERE login='" +
					newInstance.getUser() + "' AND name='" +
					newInstance.getName() + "'";
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
