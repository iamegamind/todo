package todolist;
import javax.xml.bind.annotation.XmlRootElement;


//@XmlRootElement(name="ToDo")
public class ToDo {
	
	private String user;
	private String date;
	private String name;
	private String priority;
	private String description;
	private Boolean done;
	ToDo () {
		
	}
	public ToDo(String user, String date, String name, String priority, 
			String description, Boolean done) {
		setDate(date);
		setDescription(description);
		this.user=user;
		this.name=name;
		this.done=done;
		this.priority=priority;
	}
	@Override
	public String toString() {
		String str = "Name: " + name + "\nDescription: " + description + "\nDate: " + date
			+ "\nPriority: " + priority + "\nDone: " + done + "\n";
		return str;
	}
	
	/**
	 * @param usr the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the user login
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		if (date.isEmpty()) 
			this.date = "no date";
		else 
			this.date = date;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
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
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		if (description.isEmpty())
			this.description = "no description"; 
		else
			this.description = description;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param done the done to set
	 */
	public void setDone(Boolean done) {
		this.done = done;
	}
	/**
	 * @return the done
	 */
	public Boolean isDone() {
		return done;
	}
	/**
	 * @param id the id to set
	 */


}
