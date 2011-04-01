package todolist.daos;

import todolist.daos.db.DBDAOFactory;
import todolist.daos.xml.XmlDAOFactory;

public abstract class DAOFactory {
	
	public static final int XMLFACTORY = 1;
	public static final int DBFACTORY = 2;
	
	public abstract UserDAO getUserDAO();
	public abstract ToDoDAO getToDoDAO();
	
	public abstract void setParametrs(String param1, String param2, String param3);
	
	public static DAOFactory getDAOFactory (int whichFactory) {
		
		switch (whichFactory) {
		
			case XMLFACTORY:
				return new XmlDAOFactory();
		
			case DBFACTORY:
				return new DBDAOFactory();
		}
		return null;
	}
	
}
