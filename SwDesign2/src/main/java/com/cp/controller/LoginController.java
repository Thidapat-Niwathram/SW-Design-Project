package com.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cp.model.Bill;
import com.cp.model.Lease;
import com.cp.service.BillService;
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

	@Autowired
	private BillService billService;

	@Autowired
	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	@PostMapping("/")
	public String processLoginForm(String username, String password) {
		List<Lease> leases = leaseService.getAllLease();

		for (Lease l : leases) {
			if ("on".equals(l.getLease_status())) {
				if (username.equals(l.getRoom().getRoom_id())
						&& password.equals(l.getResident().getId_card())) {
					String redirectUrl = "/dashboard/" + l.getLease_id();
		            return "redirect:" + redirectUrl;
				}
			}
		}
		if (username.equals("root") && password.equals("1234")) {
			return "redirect:/dashboard-owner";
		}
		return "redirect:";
	}

	@GetMapping("/dashboard/{id}")
	public String getDashboard(@PathVariable("id") Lease lease, Model model) {
		model.addAttribute("lease", lease);
		return "dashboard-resident";
	}

	@GetMapping("/bill/{id}")
	public String getBillUser(@PathVariable("id") Lease lease, Model model) {
		List<Bill> billList = billService.getBillByLease(lease);
		Bill lastBill = leaseService.findLatestBill(lease);
		model.addAttribute("billList", billList);
		model.addAttribute("lease", lease);
		model.addAttribute("bill", lastBill);
		return "bill-resident";
	}

}
