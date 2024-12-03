package com.collabor8.controller;

import com.collabor8.dto.RoomDto;
import com.collabor8.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/join/{id}")
    public ResponseEntity<?> joinRoom(@PathVariable long id, @Valid @RequestBody List<Long> participantIds) {
        roomService.joinRoom(id, participantIds);
        return ResponseEntity.status(HttpStatus.OK).body("Room joined Successfully");
    }
}
