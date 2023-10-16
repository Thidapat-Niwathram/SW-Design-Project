package com.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cp.service.BillService;
import com.cp.service.LeaseService;

@Controller
public class PageController {
		
	@GetMapping("/dashboard-owner")
	public String getDashboardOwner() {
		return "dashboard-owner";
	}
	
	@GetMapping("/dashboard-resident")
	public String getDashboardResident() {
		return "dashboard-resident";
	}
}
