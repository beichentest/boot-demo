package com.hys.boot.consumer.conf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {
	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	public String handleError() {
		return "common/404";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
