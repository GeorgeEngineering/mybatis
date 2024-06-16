package com.george.engineering.myBatis.controller;

import com.george.engineering.myBatis.mapper.TaskMapper;
import com.george.engineering.myBatis.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/tasks")
public class TaskController {
    @Autowired
    private TaskMapper taskMapper;

    public TaskController(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @GetMapping("")
    public List<Task> getAll() {
        return taskMapper.selectAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable String id) {
        return taskMapper.selectById(Integer.parseInt(id));
    }

    @PostMapping("")
    public void add(@RequestBody Task task) {
        taskMapper.insert(task);
    }

    @PutMapping("/{id}")
    private void update(@PathVariable String id, @RequestBody Task task) {
        taskMapper.update(Integer.parseInt(id), task.getDescription(), task.getPriority());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        taskMapper.delete(Integer.parseInt(id));
    }


    @GetMapping("/update")
    private List<Task> update() {
        taskMapper.insert(new Task("Drink water.", 10));
        taskMapper.insert(new Task("Fix bed first thing in the morning.", 10));
        taskMapper.insert(new Task("Feed pets in the morning.", 10));
        taskMapper.insert(new Task("Have breakfast.", 10));
        taskMapper.insert(new Task("Clean dishes after having my breakfast.", 10));
        taskMapper.insert(new Task("Drink water.", 10));
        taskMapper.insert(new Task("Work in the morning.", 10));
        taskMapper.insert(new Task("Feed pets in the afternoon.", 10));
        taskMapper.insert(new Task("Have lunch.", 10));
        taskMapper.insert(new Task("Clean dishes after having my lunch.", 10));
        taskMapper.insert(new Task("Drink water.", 10));
        taskMapper.insert(new Task("Clean dishes after lunch.", 10));
        taskMapper.insert(new Task("Work in the afternoon.", 10));
        taskMapper.insert(new Task("Feed pets in the evening.", 10));
        taskMapper.insert(new Task("Have dinner.", 10));
        taskMapper.insert(new Task("Clean dishes after having my dinner.", 10));
        taskMapper.insert(new Task("Drink water.", 10));
        taskMapper.insert(new Task("Study for master's degree.", 9));
        taskMapper.insert(new Task("Workout.", 4));
        taskMapper.insert(new Task("Take protein.", 5));
        taskMapper.insert(new Task("Talk to my family and friends.", 7));
        taskMapper.insert(new Task("Clean my cloth.", 10));
        taskMapper.insert(new Task("Take a shower.", 10));
        taskMapper.insert(new Task("Sleep early", 2));
        taskMapper.insert(new Task("Make this fabricated task list in GitHub for the social engineer hacker." +
                "PD: please put water for my plants too.", 2));

        return taskMapper.selectAll();
    }
}
