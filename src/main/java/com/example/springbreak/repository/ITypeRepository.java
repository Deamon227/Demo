package com.example.springbreak.repository;

import com.example.springbreak.model.dto.CountTask;
import com.example.springbreak.model.entity.Type;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ITypeRepository extends JpaRepository<Type, Long> {
    @Query(nativeQuery = true, value = "select ty.name, count(t.name) as taskNo from type ty left join task t on ty.id = t.type group by ty.name;")
    Iterable <CountTask> countNumberTask();
    @Modifying
    @Query(nativeQuery = true, value = "call checkDeleteType(:id);")
    void checkDeleteType(@Param("id") Long id);

    Iterable<Type> findByNameContaining(String search);
}
