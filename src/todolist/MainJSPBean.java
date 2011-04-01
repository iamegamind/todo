package todolist;
import java.util.ArrayList;
public class MainJSPBean {

	private User currentUser;
	private Controller controller;
	private int done = 0;
	private int undone = 0;
	private int all = 0;

	public ArrayList<ToDo> getToDos() {
		ArrayList<ToDo> list = controller.getToDos();
		for (ToDo t : list) {
			all++;
			if (t.isDone())
				done++;
			else
				undone++;
		}
		return list;
	}
	
	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	/**
	 * @return the currentUser
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * @param all the all to set
	 */
	public void setAll(int all) {
		this.all = all;
	}

	/**
	 * @return the all
	 */
	public Integer getAll() {
		return all;
	}

	/**
	 * @param undone the undone to set
	 */
	public void setUndone(int undone) {
		this.undone = undone;
	}

	/**
	 * @return the undone
	 */
	public Integer getUndone() {
		return undone;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(int done) {
		this.done = done;
	}

	/**
	 * @return the done
	 */
	public Integer getDone() {
		return done;
	}
}
