package com.solera.group4.mainFolder.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.group4.BackendProjectSolera.entities.Group;

@RestController
public class GroupController {
	
	@RequestMapping("/courses")
	public List<Group> retrieveAllCourses() {
	}

}
