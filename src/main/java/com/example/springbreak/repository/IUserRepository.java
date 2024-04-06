package com.example.springbreak.repository;

import com.example.springbreak.model.dto.CountUserPerRole;
import com.example.springbreak.model.dto.UserDTO;
import com.example.springbreak.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query(nativeQuery = true, value = "select user.id, username as name from user join user_roles on user.id = user_roles.user_id\n" +
            "left join role on user_roles.roles_id = role.id\n" +
            "where role.id = :id")
    Iterable<UserDTO> getUserPerRole(@Param("id") Long id);
}
