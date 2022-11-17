package com.solera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.DTO.AssignmentDTO;
import com.solera.entities.Assignment;
import com.solera.repositories.AssignmentRepository;

@Service
public class AssignmentService {
    
    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignments() {
        return assignmentRepository.findAll();
    }

    public String createAssignment(AssignmentDTO assignment) throws Exception {
        if(assignmentRepository.existsByName(assignment.getName())) {
        throw new Exception("There's already an assignment called " + assignment.getName() + ", pick a different name please.");
        }
        Assignment assignment2 = new Assignment(assignment.getName(), assignment.getDescription(), assignment.getPoints());
        assignmentRepository.save(assignment2);
        return "Assignment saved correctly!";
    }


}
