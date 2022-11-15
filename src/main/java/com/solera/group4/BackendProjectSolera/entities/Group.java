package com.solera.group4.BackendProjectSolera.entities;


import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@NoArgsConstructor
@Setter
@Getter
public class Group {

    
	private String name;
    private List<Assignment> assignmentList;
    private int points;
    
}