package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examly.springapp.model.User;



public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByUsername(String username);
	
	@Query(value="select username from user where email=:mail",nativeQuery=true)
	public String findUsername(@Param("mail") String mail);

	@Query(value="select *from user where email=:mail",nativeQuery=true)
	public User checkEmailExist(@Param("mail") String mail);
	
	@Query(value="select *from user where mobile_number=:mobileno",nativeQuery=true)
	public User checkMobile(@Param("mobileno") String mobileno);

	@Query(value="select *from user where username=:username",nativeQuery=true)
	public User checkUsername(@Param("username")String username);
}