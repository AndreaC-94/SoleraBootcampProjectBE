package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import entities.Group;
import repositories.GroupRepository;

@Service
public class GroupServices {

    @Autowired
    GroupRepository groupRepository;

    public List<Group> getAllGroup() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }
    
    public String createGroup(String group) throws Exception {
        if(groupRepository.existsById(group)) throw new Exception("This group name already exists, pick a different name please.");
        else{
            groupRepository.save(new Group (group));
            return "A new group named " + group + " created!";
        }
    }
    
    public String deleteGroup(String groupName) {
        if(groupRepository.existsById(groupName)){
            groupRepository.deleteById(groupName);
            return "Group \"" + groupName + "\" has been deleted.";
        }
        return "The group \"" + groupName + "\" does not exist, enter a valid group name.";
    }
    
    public String editGroup(String groupNameNow, String groupNameNew) throws Exception {
        //TODO
        createGroup(groupNameNew);
        deleteGroup(groupNameNow);

        return "Group \"" + groupNameNow + "\" has been changed to \"" + groupNameNew + "\"";
    }
}
