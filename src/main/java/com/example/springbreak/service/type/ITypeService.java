package com.example.springbreak.service.type;

import com.example.springbreak.model.dto.CountTask;
import com.example.springbreak.model.entity.Type;
import com.example.springbreak.service.IGeneratedService;
import org.springframework.stereotype.Service;

@Service
public interface ITypeService extends IGeneratedService<Type> {
    Iterable<CountTask> countTaskNo();
    Iterable<Type> findByNameContaining(String search);
}
