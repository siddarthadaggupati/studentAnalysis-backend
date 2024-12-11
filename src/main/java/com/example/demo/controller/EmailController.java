package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.EmailManager;

@RestController
@RequestMapping("/email")
public class EmailController 
{
	@Autowired
	EmailManager em;
	
	@GetMapping("/send")
	public String send(@RequestParam("email")String toMail)
	{
		String frommail="examportala2@gmail.com";
		String toemail=toMail;
		String subject="welcome to emailing";
		String text="Link for resetting the password http://localhost:5173/updatepwd";
		return em.sendEmail(frommail, toemail, subject, text);
	}

}