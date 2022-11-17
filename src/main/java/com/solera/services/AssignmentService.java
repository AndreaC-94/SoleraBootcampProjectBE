package com.solera.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.entities.Assignment;
import com.solera.repositories.AssignmentRepository;

@Service
public class AssignmentService {
    
    @Autowired
    AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignments() {
        return assignmentRepository.findAll();
    }

    public String createAssignment(Assignment assignment) {
        return null;
    }


}
