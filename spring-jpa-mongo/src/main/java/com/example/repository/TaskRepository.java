package com.example.repository;

import com.example.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByAssigneeAndPriority(String assignee, String priority);

    @Query(value = "{assignee: ?0 ,priority: ?1}",fields = "{'description' : 1 , 'storyPoint': 2}")
    List<Task> finTaskWithAssigneeAndPriority(String assignee, String priority);
}
