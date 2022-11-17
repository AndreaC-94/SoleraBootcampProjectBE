package com.solera.controllers;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.entities.Assignment;
import com.solera.services.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    
    @Autowired
    AssignmentService assignmentService;

    @GetMapping
    public ResponseEntity<?> getAssignments(){
        try{
            List<Assignment> assignments = assignmentService.getAssignments();
            return new ResponseEntity<List<Assignment>>(assignments, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createAssignment(@RequestBody Assignment assignment){
        try{
            String msg = assignmentService.createAssignment(assignment);
        }catch(Exception e){

        }
        return null;
    }
}
