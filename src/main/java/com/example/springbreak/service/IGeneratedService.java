package com.example.springbreak.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IGeneratedService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save (T t);
    void deleteById(Long id);
}
