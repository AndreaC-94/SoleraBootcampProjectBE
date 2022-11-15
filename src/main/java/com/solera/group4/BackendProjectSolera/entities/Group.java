package com.solera.group4.BackendProjectSolera.entities;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@NoArgsConstructor
@Setter
@Getter
public class Group {

    private Integer id;
	private String name;
    private List<Assignment> assignmentList;
    private int points;
    
	public Group(String name, int id) {
		super();
		this.id = id;
		this.name = name;
		this.assignmentList = new ArrayList<Assignment>();
		this.points = 0;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", assignmentList=" + assignmentList + ", points=" + points + "]";
	}

	public Integer getId() {
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
    
    
}