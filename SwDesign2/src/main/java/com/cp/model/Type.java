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
@Table(name="type")
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="type_id")
 	private Integer type_id;
	
	@Column(name="price")
	private String price;

	@Column(name="room_desc")
	private String room_desc;
	
	@OneToMany(targetEntity=Room.class, mappedBy="type",
    		cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> room;

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRoom_desc() {
		return room_desc;
	}

	public void setRoom_desc(String room_desc) {
		this.room_desc = room_desc;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public Type(Integer type_id, String price, String room_desc, List<Room> room) {
		super();
		this.type_id = type_id;
		this.price = price;
		this.room_desc = room_desc;
		this.room = room;
	}
	
}
