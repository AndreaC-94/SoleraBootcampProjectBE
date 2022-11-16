package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.GroupRepository;

@Service
public class GroupServices {

    @Autowired
    GroupRepository groupRepository;
    
}
