package com.example.springbreak.controller;

import com.example.springbreak.model.entity.Task;
import com.example.springbreak.service.task.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private ITaskService taskService;
    @GetMapping()
    public ModelAndView showIndex(){
        ModelAndView m = new ModelAndView("index", "task", taskService.findAll());
        return m;
    }
    @GetMapping("/create")
    public ModelAndView showForm(){
        ModelAndView m = new ModelAndView("add", "task", new Task());
        return m;
    }
    @PostMapping("/create")
    public String add(Task task){
        taskService.save(task);
        return "redirect:/task";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        ModelAndView m = new ModelAndView("edit", "task", taskService.findById(id));
        return m;
    }
    @PostMapping("/edit/{id}")
    public String edit(Task task, @PathVariable Long id){
        task.setId(id);
        taskService.save(task);
        return "redirect:/task";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        taskService.deleteById(id);
        return "redirect:/task";
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String search){
        ModelAndView m = new ModelAndView("index", "task", taskService.findAllByNameContaining(search));
        return m;
    }
}
