package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cp.model.Bill;
import com.cp.service.BillService;

@Controller
public class BillController {
	private BillService billService;

	@Autowired
	public void setBillService(BillService billService) {
		this.billService = billService;
	}

//	  @RequestMapping("/bill")
//	  public String getCategoryList(Model model) {
//		  List<Bill> categoryList =  (List<Category>) inventoryService.getCategoryById(3); 
//		  model.addAttribute("categoryList",categoryList);
//		  return "categoryList";
//	  }
	@GetMapping("/delete_bill/{id}")
	public String deleteBill(@PathVariable("id") Integer id, Model model) {
		Bill bill = billService.getBillById(id);
		billService.deleteBill(bill);
		return "redirect:/Bill";
	}

}
