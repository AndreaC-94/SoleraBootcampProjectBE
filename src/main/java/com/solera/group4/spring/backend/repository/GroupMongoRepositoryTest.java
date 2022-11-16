package com.solera.group4.spring.backend.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.solera.group4.spring.backend.entitites.Group;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GroupMongoRepositoryTest {
	
	@Autowired
	private GroupRepository groupMongoRepository;
	
	@Before
	public void setUp() throws Exception {
		Group group1 = new Group("group1");
		Group group2 = new Group("group2");
		assertNull(group1.getId());
		assertNull(group2.getId());
		group1.setNewAssignment("Learn React", "Learn you a React for great good", 100);
		group1.setNewAssignment("Learn Spring", "Learn you a Spring for great good", 70);
		this.groupMongoRepository.save(group1);
		this.groupMongoRepository.save(group2);
		assertNotNull(group1.getId());
		assertNotNull(group2.getId());
	}
	
	@Test
	public void testFetchData() {
		Group groupA = groupMongoRepository.findByName("group1");
		assertNotNull(groupA);
		assertEquals("Learn React", groupA.getAssignmentList().get(0).getName());
		Iterable<Group> groups = groupMongoRepository.findAll();
		int count =0;
		for(Group p : groups) {
			count++;
		}
		assertEquals(count, 2);
	}
	
	@Test
	public void testDataUpdate() {
		Group groupB = groupMongoRepository.findByName("group1");
		groupB.setPoints(200);
		groupMongoRepository.save(groupB);
		Group groupC = groupMongoRepository.findByName("group1");
		assertNotNull("groupC");
		assertEquals(200, groupC.getPoints());
	}
	
	@After
	public void tearDown() throws Exception {
		this.groupMongoRepository.deleteAll();
	}
}
