package com.collabor8.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(long id) {
        super("Room Not Found with Given id:"+id);
    }
}
