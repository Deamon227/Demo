package com.example.springbreak.service.type;

import com.example.springbreak.model.dto.CountTask;
import com.example.springbreak.model.entity.Type;
import com.example.springbreak.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService implements ITypeService{
    @Autowired
    private ITypeRepository typeRepository;
    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void deleteById(Long id) {
        typeRepository.checkDeleteType(id);
    }

    @Override
    public Iterable<CountTask> countTaskNo() {
        return typeRepository.countNumberTask();
    }

    @Override
    public Iterable<Type> findByNameContaining(String search) {
        return typeRepository.findByNameContaining(search);
    }
}
