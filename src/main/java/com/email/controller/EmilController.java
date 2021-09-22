package com.email.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.EmailEnitity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Email Controller", description = "REST APIs related to Email Entity!!!!")
@RequestMapping("/api/email")
@RestController
public interface EmilController {
	
	
	
	@ApiOperation(value = "Create Email in the System ", tags = "Create Email")

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 201, message = "Success|Created"),

			@ApiResponse(code = 401, message = "not authorized!"),

			@ApiResponse(code = 403, message = "forbidden!!!"),

			@ApiResponse(code = 404, message = "not found!!!") })

	@PostMapping(value = "/save/employee")
	public String saveEmployee(@RequestBody EmailEnitity emailEnitity);


}
