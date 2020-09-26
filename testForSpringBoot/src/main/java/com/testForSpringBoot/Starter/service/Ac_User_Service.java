package com.testForSpringBoot.Starter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testForSpringBoot.Starter.dao.Ac_User_Dao;
import com.testForSpringBoot.Starter.model.Ac_User_Model;

@Service
public class Ac_User_Service {

	@Autowired
	private Ac_User_Dao ac_user_dao;

	public List<Ac_User_Model> addUser(Ac_User_Model ac_user_model) {

		List<Ac_User_Model> list = new ArrayList<Ac_User_Model>();
		Ac_User_Model i = new Ac_User_Model();
		try {
			i = ac_user_dao.save(ac_user_model);
			if (i != null) {
				list = ac_user_dao.getuserList();
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	public List<Ac_User_Model> getUser() {
		List<Ac_User_Model> list = new ArrayList<Ac_User_Model>();
		try {
			list = ac_user_dao.getuserList();
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	public List<Ac_User_Model> getUserById(int id) {
		List<Ac_User_Model> list = new ArrayList<Ac_User_Model>();
		try {
			list = ac_user_dao.getUserById(id);
		} catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	public List<Ac_User_Model> updateUser(Ac_User_Model ac_user_model) {
		try {
			int i = ac_user_dao.updateUser(ac_user_model.getId(), ac_user_model.getF_name(), ac_user_model.getL_name(),
					ac_user_model.getEmail(), ac_user_model.getPwd(), ac_user_model.getContact(),
					ac_user_model.getFlag(), ac_user_model.getRights());
			if (i > 0) {
				return ac_user_dao.getUserById(ac_user_model.getId());
			} else {
				return null;
			}
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}

	public List<Ac_User_Model> deleteUser(int id) {
		try {
			int i = ac_user_dao.deleteUser(id);
			if (i > 0) {
				return ac_user_dao.getuserList();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}
}
