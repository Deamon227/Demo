package com.example.springbreak.controller;

import com.example.springbreak.model.entity.Task;
import com.example.springbreak.service.task.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/task")
public class ApiTaskController {
    @Autowired
    private ITaskService taskService;
    @GetMapping("")
    public ResponseEntity<Iterable<Task>> showList(){
        Iterable<Task> tasks = taskService.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        taskService.save(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> editTask(@PathVariable long id, @RequestBody Task task){
        if (taskService.findById(id).isPresent()){
            task.setId(id);
            taskService.save(task);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id){
        if (taskService.findById(id).isPresent()) {
            taskService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Task>> searchKey(@RequestParam String key){
        Iterable<Task> found = taskService.findAllByNameContaining(key);
        return new ResponseEntity<>(found, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable Long id){
         Optional<Task> t = taskService.findById(id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

}
