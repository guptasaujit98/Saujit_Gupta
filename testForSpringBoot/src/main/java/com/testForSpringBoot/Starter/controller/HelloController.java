package com.testForSpringBoot.Starter.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testForSpringBoot.Starter.model.ListModel;
import com.testForSpringBoot.Starter.service.ListService;
import com.testForSpringBoot.Starter.utils.GetClientIP;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class HelloController {

	@Autowired
	private ListService listService;

	@Autowired
	public JavaMailSender javaMailSender;

	@Autowired
	public static GetClientIP GetClientIP;

	@GetMapping("/hello")
	public String sayHello() {
		return "HELLO WORLD!!";

	}

	@GetMapping("/getList")
	@ApiOperation(value = "With this api we can get total list", notes = "We can get all list", response = ListModel.class)
	public List<ListModel> getList() {
		return listService.getAllList();

	}

	@PostMapping("/getListById")
	public ListModel getListByid(
			@ApiParam(value = "We need an ID to get perticuler details", required = true) @RequestBody String id) {
		return listService.getListById(id);

	}

	@PostMapping("/getList")
	public List<ListModel> addList(@RequestBody ListModel listModel) {
		listService.addList(listModel);
		return getList();

	}

	@PostMapping("/sendEmail")
	public void run(String args[]) {

		System.out.println("Sending Email...");

		// sendEmail();
		try {
			sendEmailWithAttachment();
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done");

	}

	void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("saujit.gupta@onpassive.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

	}

	void sendEmailWithAttachment() throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("saujit.gupta@onpassive.com");
		helper.setSubject("Testing from Spring Boot");
		helper.setText("<h1>Check attachment for image!</h1>", true);
		helper.addAttachment("mypic.PNG", new ClassPathResource("26062020.PNG"));

		javaMailSender.send(msg);

	}

	void getclientip(HttpServletRequest req) {
		String ip = GetClientIP.getClientIpAddr(req);
		System.out.println("IP ########" + ip);

	}

	@PostMapping("/getIp")
	public void getclientipp(String args[], HttpServletRequest req) {

		getclientip(req);

		System.out.println("Done");

	}

	/*
	 * public static void main(String args[]) { String os =
	 * System.getProperty("os.name"); System.out.println("Using System Property: " +
	 * os);
	 * 
	 * if (os.contains("Windows")) { System.out.println("########  OK  ########"); }
	 * else { System.out.println("########  NOT OK  ########"); }
	 * 
	 * }
	 */

}
