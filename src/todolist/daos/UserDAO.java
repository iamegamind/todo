package todolist.daos;

import todolist.User;

public interface UserDAO {
	
	public void create (User newInstance);
	
	public void delete (User object);
	
	public User get (String login);
	
	public void update (User newInstance);
	
	public void close ();

}

