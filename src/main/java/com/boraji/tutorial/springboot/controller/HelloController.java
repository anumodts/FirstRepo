package com.boraji.tutorial.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boraji.tutorial.springboot.entity.UserDetailsEntity;
import com.boraji.tutorial.springboot.model.SearchCriteria;
import com.boraji.tutorial.springboot.service.SpringBootService;

@Controller
@ComponentScan("com.boraji.tutorial.springboot")
public class HelloController {

	@Autowired
	SpringBootService springBootService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/createUser")
	public String createUser() {
		return "userdetails";
	}
	
	@RequestMapping("/checkuser")
	public ResponseEntity<?> checkUser( @Valid @RequestBody SearchCriteria search, Errors errors) {
		System.out.println("inside check user");
//		System.out.println("User name is "+search.getUsername());
		Boolean isUserExists=springBootService.checkUser(search.getUsername());
		System.out.println("inside check user, user existance status is "+isUserExists);
		 return ResponseEntity.ok(isUserExists);
	}

	@RequestMapping("/saveuser")
	public String saveUser(@RequestParam("username") String userName, @RequestParam("password") String password,
			@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
			@RequestParam("emailid") String emailId, @RequestParam("phone") String phoneNumber, Model m) {
		UserDetailsEntity uerDetailsEntity = new UserDetailsEntity();
		uerDetailsEntity.setUserName(userName);
		uerDetailsEntity.setPassword(password);
		uerDetailsEntity.setFirstName(firstName);
		uerDetailsEntity.setLastName(lastName);
		uerDetailsEntity.setEmailId(emailId);
		uerDetailsEntity.setPhoneNumber(phoneNumber);

		springBootService.saveUser(uerDetailsEntity);
		return "userdetails";
	}

	@PostMapping("/hello")
	public String sayHello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
}