package com.cp.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="month")
public class Month {
	@Id
    @Column(name="pay_date")
 	private Long pay_date;
	@Column(name="last_pay_date")
 	private Long last_pay_date;
	@OneToMany(targetEntity=Bill.class, mappedBy="month",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bill> bill_month;
	public Long getPay_date() {
		return pay_date;
	}
	public void setPay_date(Long pay_date) {
		this.pay_date = pay_date;
	}
	public Long getLast_pay_date() {
		return last_pay_date;
	}
	public void setLast_pay_date(Long last_pay_date) {
		this.last_pay_date = last_pay_date;
	}
	public List<Bill> getBill_month() {
		return bill_month;
	}
	public void setBill_month(List<Bill> bill_month) {
		this.bill_month = bill_month;
	}
	

}
