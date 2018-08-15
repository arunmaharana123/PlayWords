package com.arun.word.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arun.word.domain.UserRoles;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRoles, Long> {
	
	@Query("select a.role from UserRoles a, User b where b.userName=?1 and a.userId = b.userId")
    public List<String> findRoleByUserName(String username);
	
}