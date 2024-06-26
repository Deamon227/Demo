package com.example.springbreak.repository;

import com.example.springbreak.model.dto.CountUserPerRole;
import com.example.springbreak.model.dto.RoleCountDTO;
import com.example.springbreak.model.dto.UserDTO;
import com.example.springbreak.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    @Query(nativeQuery = true, value = "select r.id ,r.name, count(u.username) as userNo from role r left join user_roles ur on r.id = ur.roles_id\n" +
            "left join user u on ur.user_id = u.id group by r.id")
    Iterable<CountUserPerRole> countRoleByUser();
    @Query(nativeQuery = true, value = "select id, username as name from user join user_roles on user.id = user_roles.user_id where user_roles.roles_id = :id")
    Iterable<UserDTO> getUserByRoleId(@Param("id") Long id);
}
