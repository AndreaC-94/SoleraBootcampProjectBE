package entitites;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Assignments")
public class Assignment {
	
	@Id
	private int id;
	private String name;
	private String description;
	private int point;
	private Group owner;
	
	
	public Assignment(String name, String description, int point) {
		super();
		this.name = name;
		this.description = description;
		this.point = point;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public Group getOwner() {
		return owner;
	}


	public void setOwner(Group owner) {
		this.owner = owner;
	}
	
	
}