package com.collabor8.exception;

public class RoomNotCreatedException extends RuntimeException {
    public RoomNotCreatedException(String name, Exception e) {
        super("Unable to create Room with the given name:"+name+"\nFind the stack trace for more details: "+e);
    }
}
