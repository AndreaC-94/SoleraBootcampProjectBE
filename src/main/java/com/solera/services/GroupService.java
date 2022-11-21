package com.solera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.DTO.GroupDTO;
import com.solera.controllers.AssignmentController;
import com.solera.entities.Group;
import com.solera.repositories.GroupRepository;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

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
    
    public String editGroup(String groupNameNow, String groupNameNew) throws Exception {
        //TODO
        createGroup(groupNameNew);
        //deleteGroup(groupNameNow);

        return "Group \"" + groupNameNow + "\" has been changed to \"" + groupNameNew + "\"";
    }
}
