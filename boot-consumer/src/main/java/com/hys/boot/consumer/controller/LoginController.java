package com.hys.boot.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hys.boot.consumer.service.MyInvocationSecurityMetadataSourceService;

@Controller
public class LoginController {
	@Autowired
	MyInvocationSecurityMetadataSourceService securityMetadataSource;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)	
    public String index(Model model){        
        return "login";
    }
	@RequestMapping(value = "/reload")
	@ResponseBody
	public String reloadPermission(){
		securityMetadataSource.loadResourceDefine();
		return "Refresh the permissions success!";
	}
}
