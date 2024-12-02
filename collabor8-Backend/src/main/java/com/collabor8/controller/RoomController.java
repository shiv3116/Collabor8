package com.collabor8.controller;

import com.collabor8.dto.RoomDto;
import com.collabor8.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collabor8/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@Valid @RequestBody RoomDto roomDto) {
        roomService.createRoom(roomDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Room Created Successfully");
    }
}
