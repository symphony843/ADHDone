package com.example.adhdone;

public class Task {
    private int taskId;
    private int iconId;
    private String tabName;
    private String description;
    private String comments;
    private String createDate;
    private String startDate;
    private String completeDate;
    private boolean active;
    private int priority;

    public Task(int taskId, int iconId, String tabName, String description, String comments, String createDate, String startDate, String completeDate, boolean active, int priority) {
        this.taskId = taskId;
        this.iconId = iconId;
        this.tabName = tabName;
        this.description = description;
        this.comments = comments;
        this.createDate = createDate;
        this.startDate = startDate;
        this.completeDate = completeDate;
        this.active = active;
        this.priority = priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", iconId=" + iconId +
                ", tabName='" + tabName + '\'' +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                ", createDate='" + createDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", completeDate='" + completeDate + '\'' +
                ", active=" + active +
                ", priority=" + priority +
                '}';
    }
}
