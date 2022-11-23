package com.solera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.DTO.GroupAssignmentDTO;
import com.solera.DTO.GroupDTO;
import com.solera.controllers.AssignmentController;
import com.solera.entities.Assignment;
import com.solera.entities.Group;
import com.solera.repositories.AssignmentRepository;
import com.solera.repositories.GroupRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentController assignmentController;

    public List<Group> getAllGroup() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }
    
    public String createGroup(String groupName) throws Exception {
        if(groupRepository.existsByName(groupName)) throw new Exception("This group name already exists, pick a different name please.");
        else{
            Group group = new Group(groupName);
            int a = group.getId();
            while(true){
                if(groupRepository.existsById(group.getId())){
                    a = group.setID_GENERATOR();
                    group.setId(a);
                }
                else{
                    break;
                }
            }
            group.setID_GENERATOR();
            group.setAssignmentList(assignmentController.getAssignmentsForGroup());
            groupRepository.save(group);
            return "A new group named " + groupName + " created!";
        }
    }
    
    public String deleteGroup(GroupDTO groupData) {
        if(groupRepository.existsById(groupData.getGroupID())){
            groupRepository.deleteById(groupData.getGroupID());
            return "Group \"" + groupData.getGroupName() + "\" has been deleted.";
        }
        return "The group \"" + groupData.getGroupName() + "\" does not exist, enter a valid group name.";
    }

    public String deleteAllGroups() {
        groupRepository.deleteAll();
        return "All groups have been deleted!";
    }
    
    public String editGroup(GroupDTO group, String groupNameNew) throws Exception {
        
            Group tmpGroup = groupRepository.findById(group.getGroupID()).orElseThrow(() ->
             new Exception("The id: " + group.getGroupID() + ", is not a valid id."));

             tmpGroup.setName(groupNameNew);
             groupRepository.save(tmpGroup);
        return "Group \"" + group.getGroupName() + "\" has been changed to \"" + groupNameNew + "\"";
    }

    public String editGroupAssignment(GroupAssignmentDTO group) throws Exception{
            if(assignmentRepository.existsById(group.getAssignmentId())){
                Group tmpGroup = groupRepository.findById(group.getGroupId()).orElseThrow(() -> 
                new Exception("There's no group with id: " + group.getGroupId() + " !"));
                String assName = "error";
                System.out.println("-----BEFORE-----\n" + tmpGroup.toString());
                for (Assignment assignment : tmpGroup.getAssignmentList()) {
                    if(assignment.getId() == group.getAssignmentId()){
                        assignment.setDone(group.isDoneStatus());
                        assName = assignment.getName();
                        break;
                    }
                }
                System.out.println("-----AFTER-----\n" + tmpGroup.toString());
                String output = group.isDoneStatus() ? "done":"not done";
                groupRepository.save(tmpGroup);
                return "Assignment \"" + assName + "\" has been setted to " + output;
            }
            else{
                throw new Exception("There's no assignment with id: " + group.getAssignmentId() + " !");
            }
    }
}
