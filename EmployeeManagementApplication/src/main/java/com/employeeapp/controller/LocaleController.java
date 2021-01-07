package com.employeeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Satheeshkumar V
 *
 */
@Controller
public class LocaleController {

	@GetMapping("/locale")
	public String home() {
		return "home";
	}
}
