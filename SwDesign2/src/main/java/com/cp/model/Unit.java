package com.cp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="unit")
public class Unit {
	public Integer getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(Integer unit_id) {
		this.unit_id = unit_id;
	}
	public Integer getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(Integer unit_price) {
		this.unit_price = unit_price;
	}
	public Integer getUnit_desc() {
		return unit_desc;
	}
	public void setUnit_desc(Integer unit_desc) {
		this.unit_desc = unit_desc;
	}
	public List<Bill> getBill_unit() {
		return bill_unit;
	}
	public void setBill_unit(List<Bill> bill_unit) {
		this.bill_unit = bill_unit;
	}
	@Id
    @Column(name="unit_id")
 	private Integer unit_id;
	@Column(name="unit_price")
 	private Integer unit_price;
	@Column(name="unit_desc")
 	private Integer unit_desc;
	@OneToMany(targetEntity=Bill.class, mappedBy="unit",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bill> bill_unit;
}
