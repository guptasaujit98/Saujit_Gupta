package com.testForSpringBoot.Starter;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.testForSpringBoot.Starter.controller.UploadController;
import com.testForSpringBoot.Starter.dao.Ac_User_Dao;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = Ac_User_Dao.class)
public class TestForSpringBootAPI {

	public static void main(String[] args) {
		new File(UploadController.UPLOADED_FOLDER).mkdir();
		SpringApplication.run(TestForSpringBootAPI.class, args);

	}
	

}
