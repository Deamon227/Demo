package com.example.springbreak.service.task;

import com.example.springbreak.model.entity.Task;
import com.example.springbreak.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService implements ITaskService{
    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Iterable<Task> findAllByNameContaining(String search) {
        if(search == null){
            return taskRepository.findAll();
        }else {
            return taskRepository.findAllByNameContaining(search);
        }
    }
}
