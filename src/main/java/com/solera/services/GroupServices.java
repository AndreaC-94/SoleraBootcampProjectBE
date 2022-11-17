package com.solera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.DTO.GroupDTO;
import com.solera.entities.Group;
import com.solera.repositories.GroupRepository;

@Service
public class GroupServices {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroup() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }
    
    public String createGroup(String group) throws Exception {
        if(groupRepository.existsByName(group)) throw new Exception("This group name already exists, pick a different name please.");
        else{
            groupRepository.save(new Group (group));
            return "A new group named " + group + " created!";
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
