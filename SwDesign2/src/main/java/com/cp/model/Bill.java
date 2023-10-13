package com.cp.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_id")
	private int bill_id;
	@Column(name="start_unit")
	private int start_unit;
	@Column(name="end_unit")
	private int end_unit;
	@Column(name="water")
	private int water;
	@Column(name="electric")
	private int electric;
	@Column(name="total")
	private int total;
	@Column(name="pay_status")
	private Long pay_status;
	@Column(name="charge")
	private int charge;
	@Column(name="fridge_rent")
	private int fridge_rent;
	@Column(name="tv_rent")
	private int tv_rent;
	@Column(name="laundry")
	private int laundry;
	/* FK */
	@ManyToOne
	@JoinColumn(name="pay_date", nullable=false)
    private Month pay;
	@ManyToOne
	@JoinColumn(name="lease_id", nullable=false)
	private Lease lease;
	@ManyToOne
	@JoinColumn(name="unit_id", nullable=false)
	private Unit unit;
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getStart_unit() {
		return start_unit;
	}
	public void setStart_unit(int start_unit) {
		this.start_unit = start_unit;
	}
	public int getEnd_unit() {
		return end_unit;
	}
	public void setEnd_unit(int end_unit) {
		this.end_unit = end_unit;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	public int getElectric() {
		return electric;
	}
	public void setElectric(int electric) {
		this.electric = electric;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Long getPay_status() {
		return pay_status;
	}
	public void setPay_status(Long pay_status) {
		this.pay_status = pay_status;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public int getFridge_rent() {
		return fridge_rent;
	}
	public void setFridge_rent(int fridge_rent) {
		this.fridge_rent = fridge_rent;
	}
	public int getTv_rent() {
		return tv_rent;
	}
	public void setTv_rent(int tv_rent) {
		this.tv_rent = tv_rent;
	}
	public int getLaundry() {
		return laundry;
	}
	public void setLaundry(int laundry) {
		this.laundry = laundry;
	}
	public Month getPay() {
		return pay;
	}
	public void setPay(Month pay) {
		this.pay = pay;
	}
	public Lease getLease() {
		return lease;
	}
	public void setLease(Lease lease) {
		this.lease = lease;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	
	

}
