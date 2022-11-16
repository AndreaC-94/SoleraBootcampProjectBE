package com.solera.group4.BackendProjectSolera.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class GroupDaoService {
	private static List<Group> groups = new ArrayList<>();
	
	private static int groupCount = 0;
	
	static {
		groups.add(new Group("Team 1", ++groupCount));
		groups.add(new Group("Team 2", ++groupCount));
		groups.add(new Group("Team 3", ++groupCount));
	}
	
	public List<Group> findAll() {
		return groups;
	}
	
	public Group findOne(int id) {
		Predicate<? super Group> predicate = group -> group.getId().equals(id);
		return groups.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public Group save(Group group) {
		group.setId(++groupCount);
		groups.add(group);
		return group;
	}
	
	public void deleteById(int id) {
		Predicate<? super Group> predicate = group -> group.getId().equals(id);
		groups.removeIf(predicate);
	}
	
}
