package com.solera.entities;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Assignments")
public class Assignment {
	
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1);

	@Id
	private int id;
	private String name;
	private String description;
	private int point;
	private boolean done;
	
	
	public Assignment(String name, String description, int point) {
		this.id = ID_GENERATOR.get();
		this.name = name;
		this.description = description;
		this.point = point;
		this.done = false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
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

	public static int setID_GENERATOR() {
		return ID_GENERATOR.getAndIncrement();
	}
}