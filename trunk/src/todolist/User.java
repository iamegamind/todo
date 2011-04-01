package todolist;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="User")
public class User {
	
	private String name;
	private String login;
	private String password;
	
	User() {
	}
	
	public User (String name, String login, String password) {
		this.login = login;
		this.name = name;
		this.password = password;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param passwd the password to set
	 */
	public void setPassword(String passwd) {
		this.password = passwd;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	

}
