package todolist;

import java.util.ArrayList;

public class LoginJSPBean {
	
	private String login = "";
	private String password = "";
	private String errorMsg = "";
	private User currentUser;
	private Controller c = new Controller(Controller.XML, "user.xml", "todo.xml", null);

	public User validate() {
		currentUser = c.login(login, password);
		return currentUser;
	}
	
	public Controller getController() {
		return c;
	}
	public ArrayList<ToDo> getToDos() {
		return c.getToDos();
	}
	
	/**
	 * @param str the login to set
	 */
	public void setLogin(String str) {
		this.login = str;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param psw the password to set
	 */
	public void setPassword(String psw) {
		this.password = psw;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}




	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
}
