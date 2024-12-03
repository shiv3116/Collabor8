package com.collabor8.service;

import com.collabor8.dto.RoomDto;
import com.collabor8.entity.Room;
import com.collabor8.entity.User;
import com.collabor8.exception.RoomNotCreatedException;
import com.collabor8.exception.RoomNotFoundException;
import com.collabor8.exception.UserNotFoundException;
import com.collabor8.repository.RoomRepository;
import com.collabor8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    //Create a new room
    public void createRoom(RoomDto roomDto) {
        try {
            Room room = new Room();
            User user = userRepository.findById((long) roomDto.getOwner_id()).orElseThrow(() -> new UserNotFoundException((long) roomDto.getOwner_id()));
            room.setName(roomDto.getName());
            room.setOwner(user);
            List<Long> participantsIds = roomDto.getParticipantIds();
            List<User> participants = new ArrayList<>();
            for(long id: participantsIds) {
                user = userRepository.findById((long) id).orElseThrow(() -> new UserNotFoundException((long) id));
                participants.add(user);
            }
            room.setParticipants(participants);
            roomRepository.save(room);
        } catch(Exception e) {
            throw new RoomNotCreatedException(roomDto.getName(), e);
        }
    }

    //Join a Room
    public void joinRoom(long id, List<Long> participantIds) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        List<User> participants = room.getParticipants();
        User user;
        for(long pid: participantIds) {
            user = userRepository.findById(pid).orElseThrow(() -> new UserNotFoundException(pid));
            participants.add(user);
        }
        room.setParticipants(participants);
        roomRepository.save(room);
    }
}
