package com.solera.DTO;

import org.springframework.stereotype.Component;

@Component
public class GroupDTO {

    private int groupID;
    private String groupName;

    public GroupDTO() {
    }
    public int getGroupID() {
        return groupID;
    }
    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
}
