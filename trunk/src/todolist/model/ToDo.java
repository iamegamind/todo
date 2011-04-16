package todolist.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ToDo
 *
 */
@Entity
@Table(name="todo")

public class ToDo implements Serializable {

	
	private Long id;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;

	public ToDo() {
		super();
	}   
	@Id
	@Column(name="todo_id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
