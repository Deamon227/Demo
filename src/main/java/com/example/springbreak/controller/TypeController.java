package com.example.springbreak.controller;

import com.example.springbreak.model.dto.CountTask;
import com.example.springbreak.model.entity.Type;
import com.example.springbreak.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/type")
public class TypeController {
    @Autowired
    private ITypeService typeService;
    @GetMapping("")
    public ResponseEntity<Iterable<Type>> showList(){
        Iterable<Type> type = typeService.findAll();
        return new ResponseEntity<>(type, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Type> addType(@RequestBody Type type){
        typeService.save(type);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Type> findById(@PathVariable Long id){
        Type type = typeService.findById(id).get();
        return new ResponseEntity<>(type, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Type> editTask(@PathVariable long id, @RequestBody Type type){
        if (typeService.findById(id).isPresent()){
            type.setId(id);
            typeService.save(type);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<Type> delete(@PathVariable Long id){
        if (typeService.findById(id).isPresent()) {
            typeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/count")
    public ResponseEntity<Iterable<CountTask>> countTask(){
       Iterable<CountTask> t = typeService.countTaskNo();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}
