package todolist.daos;
import java.util.ArrayList;

import todolist.ToDo;
import todolist.User;


public interface ToDoDAO {

	public void create (ToDo newInstance);
	
	public void delete (ToDo object);
	
	public ArrayList<ToDo> get (User user);
	
	public void update (ToDo newInstance);
	
	public void close ();
}
