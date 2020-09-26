package com.testForSpringBoot.Starter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testForSpringBoot.Starter.model.ListModel;

@Service
public class ListService {
	
	private List<ListModel> list = new ArrayList<> (Arrays.asList(
			new ListModel("1","saujit","IT"),
			new ListModel("2","sanjit","FE"),
			new ListModel("3","rabindra","AWS")				
			));
	
	public List<ListModel> getAllList() {
		return list;
	}
	
	public ListModel getListById(String id) {		
		return list.stream().filter(l -> l.getId().equals(id)).findFirst().get();
	}

	public void addList(ListModel listModel) {
		list.add(listModel);
		
	}

}
