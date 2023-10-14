package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cp.model.Bill;
import com.cp.service.BillService;

@Controller
public class BillController {
	
	@Autowired
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
//	@GetMapping("/delete_bill/{id}")
//	public String deleteBill(@PathVariable("id") Integer id, Model model) {
//		Bill bill = billService.getBillById(id);
//		billService.deleteBill(bill);
//		return "redirect:/Bill";
//	}

	@RequestMapping("/bill_list_json")
	@ResponseBody
	public List<Bill> getBillList() {
		List<Bill> bill = billService.getBillAll();
		return bill;
	}

}
