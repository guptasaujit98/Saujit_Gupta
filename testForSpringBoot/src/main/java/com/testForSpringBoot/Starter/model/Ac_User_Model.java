package com.testForSpringBoot.Starter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name="ac_user")
public class Ac_User_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
	public int id;
	public String f_name;
	public String l_name;	
	public String email;
	public String pwd;
	public String contact;
	public int flag;
	public String rights;
	
	public Ac_User_Model(int id, String f_name, String l_name, String email, 
			String pwd, String contact, int flag,String rights) {
		super();
		this.id = id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.pwd = pwd;
		this.contact = contact;
		this.flag = flag;
		this.rights = rights;
	}
	
	public Ac_User_Model() {
		
	}
}
