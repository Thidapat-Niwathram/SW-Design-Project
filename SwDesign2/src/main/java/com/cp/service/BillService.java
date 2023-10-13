package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.model.Bill;
import com.cp.model.Month;
import com.cp.model.Unit;
import com.cp.repository.BillRepository;
import com.cp.repository.MonthRepository;
import com.cp.repository.UnitRepository;
import java.util.Date;

@Service
public class BillService {
	private BillRepository billRepo;
	private MonthRepository monthRepo;
	private UnitRepository unitRepo;

	@Autowired
	public void setBillRepository(BillRepository billRepository) {
		this.billRepo = billRepository;
	}

	public List<Bill> getBillAll() {
		return (List<Bill>) this.billRepo.findAll();
	}

	public Bill getBillById(Integer id) {
		return this.billRepo.findById(id).get();
	}

	public void deleteBillById(Integer id) {
		Bill bill = this.billRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
		billRepo.delete(bill);
	}
	public void deleteBill(Bill bill) {
		 this.billRepo.delete(bill);
	 }
	public void saveBill(Bill bill) {
		this.billRepo.save(bill);
	}
	/* Month */

	@Autowired
	public void setMonthRepository(MonthRepository monthRepository) {
		this.monthRepo = monthRepository;
	}

	public List<Month> getMonthAll() {
		return (List<Month>) this.monthRepo.findAll();
	}

	public Month getMonthById(Date id) {
		return this.monthRepo.findById(id).get();
	}

	public void deletMonthById(Date id) {
		Month month = this.monthRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
		monthRepo.delete(month);
	}
	public void deleteMonth(Month month) {
		 this.monthRepo.delete(month);
	 }

	public void saveMonth(Month month) {
		this.monthRepo.save(month);
	}

	/* Unit */
	@Autowired
	public void setUnitRepository(UnitRepository unitRepository) {
		this.unitRepo = unitRepository;
	}

	public List<Unit> getUnitAll() {
		return (List<Unit>) this.unitRepo.findAll();
	}

	public Unit getUnitById(int id) {
		return this.unitRepo.findById(id).get();
	}

	public void deletUnitById(int id) {
		Unit unit = this.unitRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
		unitRepo.delete(unit);
	}
	public void deleteUnit(Unit unit) {
		 this.unitRepo.delete(unit);
	 }

	public void saveUnit(Unit unit) {
		this.unitRepo.save(unit);
	}

}
