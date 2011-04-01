package todolist.daos.xml;
import java.io.File;

import todolist.daos.DAOFactory;
import todolist.daos.ToDoDAO;
import todolist.daos.UserDAO;


public class XmlDAOFactory extends DAOFactory {

	private static String USER_FILE = "user.xml";
	private static String TODO_FILE = "todo.xml";
	File fUser = null;
	File fToDo = null;
	
	@Override
	public UserDAO getUserDAO() {
		return XmlUserDAO.getInstance(fUser);
	}

	@Override
	public ToDoDAO getToDoDAO() {
		return XmlToDoDAO.getInstance(fToDo);
	}

	@Override
	public void setParametrs(String param1, String param2, String param3) {
		USER_FILE = param1;
		TODO_FILE = param2;
		fUser = new File(USER_FILE);
		fToDo = new File (TODO_FILE);
	}
	
	
}
