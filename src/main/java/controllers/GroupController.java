package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import services.GroupServices;

@RestController
public class GroupController {
    
    @Autowired
    GroupServices groupServices;
}
