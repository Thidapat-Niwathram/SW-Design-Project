package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.model.Room;
import com.cp.repository.RoomRepository;

@Service
public class RoomService {

	private RoomRepository roomRepository;

	@Autowired
	public void setRoomRepository(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@Autowired
	public RoomService(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}
	
	//get all
	public List<Room> getAllRoomRepository(){
		return (List<Room>) this.roomRepository.findAll();
		}
	//get by id
	public Room getRoomById(Integer id) {
		return this.roomRepository.findById(id).get();
	}
	//delete by id
	public void deleteRoomById(Integer id) {
		Room room = this.roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Room Id:" + id));
		roomRepository.delete(room);
	}
}
