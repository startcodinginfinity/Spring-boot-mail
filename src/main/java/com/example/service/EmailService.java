package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;

	public Map<?,?> sendEmail(User user) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		Map<String,Object> map = new HashMap<>();
		
		message.setSubject(user.getSubject());
		
		map.put("statsusCode", HttpStatus.OK.value());
		
		message.setTo(user.getToEmail());
		
		message.setText(user.getMessage());
		
		System.out.println(message);
		
		javaMailSender.send(message);
		
		map.put("message", "Email has sent successfully");
		
		return map;
	}
	
	

}
