package com.example.springbreak.service.task;

import com.example.springbreak.model.entity.Task;
import com.example.springbreak.service.IGeneratedService;

public interface ITaskService extends IGeneratedService<Task> {
    Iterable<Task> findAllByNameContaining(String search);

}
