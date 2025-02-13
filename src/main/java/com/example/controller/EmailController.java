package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.EmailService;

@RestController
@RequestMapping("/api/v1")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping(path = "/send/email")
	public ResponseEntity<Map<?,?>> sendEmail(@RequestBody User user){
		
		var response = emailService.sendEmail(user);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}

}
