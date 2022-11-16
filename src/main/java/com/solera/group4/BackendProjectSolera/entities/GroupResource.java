package com.solera.group4.BackendProjectSolera.entities;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class GroupResource {
	
	
	private GroupDaoService service;
	public GroupResource(GroupDaoService service) {
		this.service = service;
	}
	
	
	@GetMapping("/users")
	public List<Group> retrieveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Group retrieveUser(@PathVariable int id) {
		Group user = service.findOne(id);
		return user;
	}
	
	@PostMapping("/groups")
	public ResponseEntity<Group> createUser(@RequestBody Group group) {
		Group savedGroup = service.save(group);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedGroup.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
}
