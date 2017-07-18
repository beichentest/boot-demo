package com.hys.boot.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hys.boot.consumer.framework.security.ss3.CustomUserDetails;

@Controller
@RequestMapping("/web")
public class WebController {

	// ������־
	private static final Logger log = LoggerFactory.getLogger(WebController.class);

	@RequestMapping
	public String index(ModelMap map) {		
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		log.info("==============Controller=================");
		map.put("title", userDetails.getUsername()+"HelloWorld");
		return "index";
	}
}