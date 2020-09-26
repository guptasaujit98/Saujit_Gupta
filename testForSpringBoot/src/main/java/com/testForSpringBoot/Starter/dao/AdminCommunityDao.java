package com.testForSpringBoot.Starter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testForSpringBoot.Starter.model.AdminCommunityModel;

@Repository
public interface AdminCommunityDao extends JpaRepository<AdminCommunityModel, Long> {

	@Query(value = "select e.com_id,e.post_title,e.title,e.content,e.files,e.poster,e.dates,"
			+ "e.times,e.ordering from go_admincommunity e Order by e.ordering=1 desc ,e.com_id Desc", nativeQuery = true)
	List<AdminCommunityModel> getAdminCommunityData();

}
