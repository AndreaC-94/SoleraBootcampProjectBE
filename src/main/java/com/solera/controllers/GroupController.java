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
import org.springframework.web.bind.annotation.RestController;

import com.solera.entities.Group;
import com.solera.services.GroupServices;

@RestController
public class GroupController {
    
    @Autowired
    GroupServices groupServices;

    @GetMapping("/getAll")
    public List<Group> getAllGroup(){
        return groupServices.getAllGroup();
    }

    @PostMapping("/createGroup/{name}")
    @Transactional
    public ResponseEntity<String> createGroup(@PathVariable("name") String group){
        try{
            //TODO Add validation
            System.out.println("controll " + group);
            String message = groupServices.createGroup(group);
            return new ResponseEntity(message, HttpStatus.CREATED);
        }catch(Exception e){
            //String errorMessage ="something went wrong";
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteGroup")
    @Transactional
    public ResponseEntity<String> deleteGroup(String groupName){
        try{
            //TODO Add validation
            String message = groupServices.deleteGroup(groupName);
            return new ResponseEntity(message, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> editGroup(String groupNameNow, String groupNameNew) throws Exception{
        //TODO
        String message = groupServices.editGroup(groupNameNow, groupNameNew);
        return null;
    }
}
