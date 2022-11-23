package com.solera.entities;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "groups")
public class Group {
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

	@Id
	private int id;
	private String name;
    private List<Assignment> assignmentList;
    private int points;
    
	public Group(String name) {
		this.id = ID_GENERATOR.get();
		this.name = name;
		this.assignmentList = null;
		this.points = 0;
	}
	
	@Override
	public String toString() {
		String output = "\nGroup id: " + id + "\nGroup name: " + name + "\nGroup points: " + points + "\n";
		for (Assignment assignment : assignmentList) {
			output += "\nAssignment id: " + assignment.getId() + "\nAssignment name: " + assignment.getName() +
						"\nAssignment description: " + assignment.getDescription() + "\nAssignment point: " + 
						assignment.getPoint() + "\nAssignment done: " + assignment.isDone();
		}
		return output;
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

	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}
	
	public void setNewAssignment(String name, String desc, int score) {
		Assignment newAssign = new Assignment(name, desc, score);
		// newAssign.setId(SomeGlobalAssignmentValue);
		this.assignmentList.add(newAssign);
		this.points += score;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public static int setID_GENERATOR() {
		return ID_GENERATOR.getAndIncrement();
	}
}