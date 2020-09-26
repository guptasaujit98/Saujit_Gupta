package com.testForSpringBoot.Starter.model;

import lombok.Data;

@Data
public class ListModel {
	
	private String id;
	private String name;
	private String desc;
	
	public ListModel() {
		
	}
	
	public ListModel(String id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	

}
