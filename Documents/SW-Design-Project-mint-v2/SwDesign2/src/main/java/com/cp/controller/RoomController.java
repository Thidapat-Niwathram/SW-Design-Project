package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cp.model.Room;
import com.cp.service.RoomService;

@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	public void setRoomRepository(RoomService roomService) {
		this.roomService = roomService;
	}
//	
//	@RequestMapping("/rooms")
	@GetMapping("/rooms")
	public String showAllRoom(Model model) {
		List<Room> room = roomService.getAllRoomRepository();
		model.addAttribute("room", room);
		return "room-status-owner";
		
	}

}
