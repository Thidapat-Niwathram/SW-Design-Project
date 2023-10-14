package com.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cp.model.Lease;
import com.cp.service.LeaseService;
import java.util.List;

@Controller
public class LoginController {

	@Autowired
	private LeaseService leaseService;

	@Autowired
	public void setLeaseService(LeaseService leaseService) {
		this.leaseService = leaseService;
	}

	@GetMapping("/")
	public String showLoginForm(Model model) {
		model.addAttribute("loginForm", new Lease());
		return "index";
	}

	@PostMapping("/")
	public String processLoginForm(String username, String password) {
		List<Lease> leases = leaseService.getAllLease();
		
		for (Lease lease : leases) {
		    if ("on".equals(lease.getLease_status())) {
		        if (username.equals(lease.getRoom().getRoom_id()) &&
		            password.equals(lease.getResident().getId_card())) {
		        	System.out.print("Login !!!"+ " " + username + " " + password);
		        	return "redirect:dashboard-resident";
		        }
		    }
		}
		if (username.equals("root") &&
	            password.equals("1234")) {
	        	System.out.print("Login !!!"+ " " + username + " " + password);
	        	return "redirect:dashboard-owner";
	        }
		return "redirect:";
	}

}
