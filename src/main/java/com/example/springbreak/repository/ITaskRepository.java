package com.example.springbreak.repository;

import com.example.springbreak.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
    Iterable<Task> findAllByNameContaining(String search);
}
