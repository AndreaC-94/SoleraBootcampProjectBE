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
        int a = assignment2.getId();
        while(true){
            if(assignmentRepository.existsById(assignment2.getId())){
                a = assignment2.setID_GENERATOR();
                assignment2.setId(a);
            }
            else{
                break;
            }
        }
        assignment2.setID_GENERATOR();
        assignmentRepository.save(assignment2);
        return "Assignment saved correctly!";
    }

    public String deleteAssignment(AssignmentDTO assignment) throws Exception {
        if(assignmentRepository.existsByName(assignment.getName())){
            assignmentRepository.deleteByName(assignment.getName());
            return "The assignment \"" + assignment.getName() + "\" has been deleted!";
        }
        throw new Exception("There's no assignment called \"" + assignment.getName() + "\".");
    }

    public String deleteAllAssignments() {
        assignmentRepository.deleteAll();
        return "All assignments have been deleted!";
    }

    public String editAssignment(Assignment assignment) throws Exception{

        Assignment tmpAss = assignmentRepository.findById(assignment.getId()).orElseThrow(() -> 
        new Exception("There's no assignment with id: " + assignment.getId()));

        tmpAss.setName(assignment.getName());
        tmpAss.setDescription(assignment.getDescription());
        tmpAss.setDone(assignment.isDone());
        tmpAss.setPoint(assignment.getPoint());

        assignmentRepository.save(tmpAss);
        return "The assignment id: " + assignment.getId() + " has been edited correctly!";
    }
}
