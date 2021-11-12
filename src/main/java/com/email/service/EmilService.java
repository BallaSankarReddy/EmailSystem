package com.email.service;

import com.email.entity.EmailEnitity;

public interface EmilService {
	
	public String sendingEmail(String toEmail, String body, String subject);
	
	public String sendSampleEmail(EmailEnitity emailEnitity);
	
	//Testing the git fetch 

}
