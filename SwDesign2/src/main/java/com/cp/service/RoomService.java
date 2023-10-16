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
		return roomRepository.findAll();
		}
	//get by id
	public Room getRoomById(String id) {
		return roomRepository.findById(id).get();
	}
	//delete by id
	public void deleteRoomById(String id) {
		Room room = this.roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Room Id:" + id));
		roomRepository.delete(room);
	}
	public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
}
