package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
//	@GetMapping("/bill")
////	@RequestMapping("/")
//	public String getBillList(Model model) {
//		List<Bill> billList = (List<Bill>) billService.getBillAll();
//		model.addAttribute("bill", billList);     
//		return "testBill";
//	}
//	
	@GetMapping("/bill")
	public String getBillById(Model model) {
		Bill billList = billService.getBillById(50);
		model.addAttribute("bill", billList);     
		return "testBill";
	}
	@RequestMapping("/bill_list_json") 
	@ResponseBody
	public List<Bill> getBillList(){
		List<Bill> bill =  billService.getBillAll();
		return bill;
	}
	

//	@GetMapping("/delete_bill/{id}")
//	public String deleteBill(@PathVariable("id") Integer id, Model model) {
//		Bill bill = billService.getBillById(id);
//		billService.deleteBill(bill);
//		return "redirect:/show_bill";
//
//	}
//
//	@PostMapping("/update_bill/{id}")
//	public String updateBill(@PathVariable("id") Integer id, @Validated Bill bill, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			bill.setBill_id(id);
//			return "update_bill";
//		}
//
//		billService.saveBill(bill);
//		return "redirect:/show_bill";
//	}

//	@GetMapping("/edit_category/{id}") // เราต้องระวัง ในแต่ละคอนโทรล ห้ามมี Url ซ้ำกัน เช่น ห้ามมี /edit/{id}
//										// ในคอนโทรลเลอร์ตัวอื่น
//	public String showUpdateBill(@PathVariable("id") Integer id, Model model) {
//		try {
//			Bill bill = billService.getBillById(id);
//
//			model.addAttribute("bill", bill);
//
//			// .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" +
//			// id));
//		} catch (Exception e) {
//			System.err.printf(e.getMessage());
//
//		}
//		return "update_category";
//	}
//	@PostMapping("/new_bill")
//	  public String addBill(@Validated Bill bill, BindingResult result, Model model) {
//	      if (result.hasErrors()) {
//	    	
//	          return "new_bill";
//	      }
//	      
//	      billService.saveBill(bill);
//	      return "redirect:/show_bill";
//	  }
//	  @GetMapping("/new_bill")
//	  public String showBill(Model model) {
//		  Bill bill = new Bill();
//	      model.addAttribute("bill", bill);
//	      return "new_category";
//	  }
	  
	
}
