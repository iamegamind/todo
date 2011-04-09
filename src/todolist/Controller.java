package todolist;

import java.util.ArrayList;
import java.util.Iterator;

import todolist.daos.DAOFactory;
import todolist.daos.ToDoDAO;
import todolist.daos.UserDAO;

public class Controller {
	
	private UserDAO userDAO;
	private ToDoDAO todoDAO;
	private ArrayList<ToDo> list = null;
	private User currentUser = null;
	public static final int XML = 1;
	public static final int DB = 2;
	
	
	/**
	 * 
	 * @param which - XML or DB
	 * @param param1 - name of user file in case of XML, DB username in case of DB
	 * @param param2 - name of todo file in case of XML, DB password in case of DB
	 * @param param3 - null in case of XML, DB port in case of DB
	 */
	public Controller(int which, String param1, String param2, String param3) {
		DAOFactory factory = null;
		switch (which) {
		
			case XML:
				factory = DAOFactory.getDAOFactory(DAOFactory.XMLFACTORY);
				break;
			case DB:
				factory = DAOFactory.getDAOFactory(DAOFactory.DBFACTORY);
				break;
		}
		
		
		factory.setParametrs(param1, param2, param3);
		userDAO = factory.getUserDAO();
		todoDAO = factory.getToDoDAO();
	}
	
	public Controller() {
		DAOFactory factory = null;
		factory = DAOFactory.getDAOFactory(DAOFactory.XMLFACTORY);
		factory.setParametrs("user.xml", "todo.xml", null);
		userDAO = factory.getUserDAO();
		todoDAO = factory.getToDoDAO();
	}
	
	public User login(String login, String pswd) {
		currentUser = userDAO.get(login);
		if (currentUser == null) return null;
		if (currentUser.getPassword().equals(pswd)) 
			return currentUser;
		else
			return null;
	}
	
	public void updateUser(User newUser) {
		userDAO.update(newUser);
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public User register (User user) {
		User us = userDAO.get(user.getLogin());
		if (us!=null) return null;
		userDAO.create(user);
		currentUser = user;
		return user;
		
	}
	
	public void close() {
		userDAO.close();
		todoDAO.close();
	}
	
	public void logout() {
		currentUser = null;
		list = null;
	}
	
	private ToDo getToDo(String name) {
		for (ToDo todo: list) 
			if (todo.getName() == name) return todo;
		return null;
	}
	
	public ArrayList<ToDo> getToDos() {
		if (list == null) {
			list = todoDAO.get(currentUser);
		}
		return list;
	}
	
	public void updateToDo(ToDo newTodo) {
		for (Iterator<ToDo> i = list.iterator(); i.hasNext();) {
			ToDo todo = i.next();
			if (todo.getName() == newTodo.getName()) {
				list.remove(todo);
				break;
			}
		}
		list.add(newTodo);
		todoDAO.update(newTodo);
		return;
	}
	
	public void deleteTodo(ToDo todo) {
		list.remove(todo);
		todoDAO.delete(todo);
	}
	
	public ToDo addToDo(ToDo todo) {
		if (list==null) list = todoDAO.get(currentUser);
		ToDo toDo = getToDo(todo.getName());
		if (toDo != null) return null;
		list.add(todo);
		todoDAO.create(todo);
		return todo;		
	}

	
}

