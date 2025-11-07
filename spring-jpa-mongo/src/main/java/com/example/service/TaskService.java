package com.example.service;

import com.example.entity.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getAllTasks();
    Task getTask(String taskId);
    Task updateTask(Task taskRequest);
    String deleteTask(String taskId);
    List<Task> getTaskByAssigneeAndPriority(String assignee, String priority);
}
