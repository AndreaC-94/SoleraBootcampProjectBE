package com.solera.entities;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "groups")
public class Group {

	@Id
	private String name;
    private List<Assignment> assignmentList;
    private int points;
    
	public Group(String name) {
		this.name = name;
		this.assignmentList = new ArrayList<Assignment>();
		this.points = 0;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + ", assignmentList=" + assignmentList + ", points=" + points + "]";
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
}