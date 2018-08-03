package com.arpico.groupit.pc_repair.dto;

public class AssigneeDto {

    private String assigneeId;
    private String assigneeName;


    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    @Override
    public String toString() {
        return "AssigneeDto{" +
                "assigneeId='" + assigneeId + '\'' +
                ", assigneeName='" + assigneeName + '\'' +
                '}';
    }
}
