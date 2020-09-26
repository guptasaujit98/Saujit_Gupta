package com.testForSpringBoot.Starter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testForSpringBoot.Starter.dao.AdminCommunityDao;
import com.testForSpringBoot.Starter.model.AdminCommunityModel;

@Service
public class AdminCommunityService {

	@Autowired
	private AdminCommunityDao admincommunitydao;

	public static String date = "";
	public static String time = "";
	public static String datetime = "";

	public List<AdminCommunityModel> getAdminCommunityData() {
		List<AdminCommunityModel> list = new ArrayList<AdminCommunityModel>();
		try {
			list = admincommunitydao.getAdminCommunityData();

			for (AdminCommunityModel adminCommunityModel : list) {

				String dateStr = adminCommunityModel.getDates();
				String year = dateStr.substring(dateStr.lastIndexOf("-") + 1);
				String month = dateStr.substring(3, dateStr.lastIndexOf("-"));
				String dateMod = dateStr.substring(0, dateStr.lastIndexOf("-"));
				String dates = dateMod.substring(0, dateMod.lastIndexOf("-"));
				String sqlformatdate = year + "-" + month + "-" + dates;

				date = sqlformatdate;
				time = adminCommunityModel.getTimes();
				datetime = date + " " + time;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;

	}

}
