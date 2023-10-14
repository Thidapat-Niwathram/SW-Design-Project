package com.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cp.service.BillService;
import com.cp.service.LeaseService;

@Controller
public class PageController {
	
//	@GetMapping("/")
//	public String getIndex() {
//		return "index";
//	}
	
	@GetMapping("/dashboard-owner")
	public String getDashboardOwner() {
		return "dashboard-owner";
	}
	
	@GetMapping("/dashboard-resident")
	public String getDashboardResident() {
		return "dashboard-resident";
	}
	
	@GetMapping("/residents-owner")
	public String getResidents() {
		return "residents-owner";
	}
	
	@GetMapping("/room-status-owner")
	public String getRoomStatus() {
		return "room-status-owner";
	}
	
	@GetMapping("/add-resident-owner")
	public String getAddResident() {
		return "add-resident-owner";
	}
	
	@GetMapping("/leases-owner")
	public String getLeaseOwner() {
		return "leases-owner";
	}
		
}
