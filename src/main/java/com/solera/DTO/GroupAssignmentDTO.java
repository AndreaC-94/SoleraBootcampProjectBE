package com.solera.DTO;

public class GroupAssignmentDTO {
    
    private int groupId;
    private int assignmentId;
    private boolean doneStatus;

    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public int getAssignmentId() {
        return assignmentId;
    }
    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }
    public boolean isDoneStatus() {
        return doneStatus;
    }
    public void setDoneStatus(boolean doneStatus) {
        this.doneStatus = doneStatus;
    }
}
