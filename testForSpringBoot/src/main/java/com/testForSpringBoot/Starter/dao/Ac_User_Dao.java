package com.testForSpringBoot.Starter.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.testForSpringBoot.Starter.model.Ac_User_Model;

@Repository
public interface Ac_User_Dao extends JpaRepository<Ac_User_Model, Long> {

	@Modifying
	@Query(value = "Insert Into ac_user (f_name,l_name,email,pwd,contact,flag,rights) "
			+ "VALUES (:f_name,:l_name,:email,:pwd,:contact,:flag,:rights)", nativeQuery = true)
	@Transactional
	int addUser(@Param("f_name") String f_name, @Param("l_name") String l_name, @Param("email") String email,
			@Param("pwd") String pwd, @Param("contact") String contact, @Param("flag") int flag,
			@Param("rights") String rights);

	/*
	 * @Query(value =
	 * "select e.id,e.f_name,e.l_name,e.email,e.pwd,e.contact,e.flag," +
	 * "e.rights from ac_user e Order by e.id Desc", nativeQuery = true)
	 * List<Ac_User_Model> getuserList();
	 */
	@Query(value = "select e.id,e.f_name,e.l_name,e.email,e.pwd,e.contact,e.flag,"
			+ "e.rights from ac_user e where e.email = :email Order by e.id Desc", nativeQuery = true)
	Ac_User_Model findByemail(@Param("email") String email);

	@Query(value = "CALL GetAllUser();", nativeQuery = true)
	List<Ac_User_Model> getuserList();

	@Query(value = "select e.id,e.f_name,e.l_name,e.email,e.pwd,e.contact,e.flag,"
			+ "e.rights from ac_user e where e.id = :id Order by e.id Desc", nativeQuery = true)
	List<Ac_User_Model> getUserById(@Param("id") int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE ac_user e SET e.f_name = :f_name,e.l_name = :l_name,"
			+ "e.email = :email,e.pwd = :pwd,e.contact = :contact,e.flag = :flag,"
			+ "e.rights = :rights where e.id = :id", nativeQuery = true)
	int updateUser(@Param("id") int id, @Param("f_name") String f_name, @Param("l_name") String l_name,
			@Param("email") String email, @Param("pwd") String pwd, @Param("contact") String contact,
			@Param("flag") int flag, @Param("rights") String rights);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM ac_user WHERE id = :id", nativeQuery = true)
	int deleteUser(@Param("id") int id);

}
