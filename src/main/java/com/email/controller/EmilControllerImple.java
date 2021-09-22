package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.EmailEnitity;
import com.email.service.EmilService;

@RequestMapping("/api/email")
@RestController
@ResponseBody
public class EmilControllerImple implements EmilController {

	
	@Autowired
	private EmilService emilService;
	@Override
	public String saveEmployee(EmailEnitity emailEnitity) {
		return emilService.sendSampleEmail(emailEnitity);
	}

}
