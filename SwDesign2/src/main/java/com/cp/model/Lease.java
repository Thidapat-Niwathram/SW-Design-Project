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
@Table(name="lease")
public class Lease {
	@Id
    @Column(name="lease_id")
 	private Integer lease_id;

	public Integer getLease_id() {
		return lease_id;
	}

	public void setLease_id(Integer lease_id) {
		this.lease_id = lease_id;
	}
	
 
}
