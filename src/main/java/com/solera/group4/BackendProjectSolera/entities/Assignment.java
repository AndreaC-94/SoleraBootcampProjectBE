package com.solera.group4.BackendProjectSolera.entities;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
	private String name;
	private String description;
	private int point;
	
	public Assignment(String name, String description, int point) {
		super();
		this.name = name;
		this.description = description;
		this.point = point;
	}
	
	
}
class AssignmentList {
	private List<Assignment> myList = new ArrayList<>();
	
}