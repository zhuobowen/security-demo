package com.demo.security.repository;

import com.demo.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("select t from User t where t.loginName =?1")
    User findByLoginName(String loginName);
}
