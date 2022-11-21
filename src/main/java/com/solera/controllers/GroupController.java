package com.solera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solera.DTO.GroupDTO;
import com.solera.entities.Group;
import com.solera.services.GroupService;

@RestController
public class GroupController {
    
    @Autowired
    private GroupService groupServices;

    @GetMapping("/getAll")
    public List<Group> getAllGroup(){
        return groupServices.getAllGroup();
    }

    @PostMapping("/createGroup/{name}")
    @Transactional
    public ResponseEntity<String> createGroup(@PathVariable("name") String group){
        try{
            String message = groupServices.createGroup(group);
            return new ResponseEntity(message, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteGroup")
    @Transactional
    public ResponseEntity<String> deleteGroup(@RequestBody GroupDTO groupData){
        try{
            String message = groupServices.deleteGroup(groupData);
            return new ResponseEntity(message, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{groupNameNew}")
    @Transactional
    public ResponseEntity<String> editGroup(@RequestBody GroupDTO group,
    @PathVariable ("groupNameNew") String groupNameNew) throws Exception{
        try{
            String message = groupServices.editGroup(group, groupNameNew);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
