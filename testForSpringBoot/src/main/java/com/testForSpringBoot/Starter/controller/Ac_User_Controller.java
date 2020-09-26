package com.testForSpringBoot.Starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testForSpringBoot.Starter.model.Ac_User_Model;
import com.testForSpringBoot.Starter.service.Ac_User_Service;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Ac_User_Controller {

	@Autowired
	private Ac_User_Service ac_user_service;

	@PostMapping("/addUser")
	public ResponseEntity<List<Ac_User_Model>> addUser(@RequestBody Ac_User_Model ac_user_model) {
		return new ResponseEntity<List<Ac_User_Model>>(ac_user_service.addUser(ac_user_model), HttpStatus.OK);
	}

	@GetMapping("/getUser")
	public ResponseEntity<List<Ac_User_Model>> getUser() {
		return new ResponseEntity<List<Ac_User_Model>>(ac_user_service.getUser(), HttpStatus.OK);
	}

	@PostMapping("/getUserById")
	public ResponseEntity<List<Ac_User_Model>> getUserById(@RequestBody int id) {
		return new ResponseEntity<List<Ac_User_Model>>(ac_user_service.getUserById(id), HttpStatus.OK);
	}

	@PostMapping("/updateUser")
	public ResponseEntity<List<Ac_User_Model>> updateUser(@RequestBody Ac_User_Model ac_user_model) {
		return new ResponseEntity<List<Ac_User_Model>>(ac_user_service.updateUser(ac_user_model), HttpStatus.OK);
	}

	@PostMapping("/deleteUser")
	public ResponseEntity<List<Ac_User_Model>> deleteUser(@RequestBody int id) {
		return new ResponseEntity<List<Ac_User_Model>>(ac_user_service.deleteUser(id), HttpStatus.OK);
	}

}
