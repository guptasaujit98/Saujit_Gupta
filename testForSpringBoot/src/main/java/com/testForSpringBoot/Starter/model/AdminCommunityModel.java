package com.testForSpringBoot.Starter.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "go_admincommunity")
public class AdminCommunityModel implements Serializable {

	private static final long serialVersionUID = 1315521749260853882L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int com_id;
	public String post_title;
	public String title;
	public String content;
	public String files;
	public String poster;
	public String dates;
	public String times;
	public int ordering;
	public String viewcount;
	public Timestamp saved_datetime;
	public Date date_s;
	public Time time_s;
	@Transient
	public String dateFormated;

	public AdminCommunityModel(int com_id, String post_title, String title, String content, String files, String poster,
			String dates, String times, int ordering, String viewcount, Timestamp saved_datetime, Date date_s,
			Time time_s) {
		super();
		this.com_id = com_id;
		this.post_title = post_title;
		this.title = title;
		this.content = content;
		this.files = files;
		this.poster = poster;
		this.dates = dates;
		this.times = times;
		this.ordering = ordering;
		this.viewcount = viewcount;
		this.saved_datetime = saved_datetime;
		this.date_s = date_s;
		this.time_s = time_s;
	}

	public AdminCommunityModel() {

	}

}
