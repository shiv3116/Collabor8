package com.collabor8.exception;

public class UserNotRegistered extends RuntimeException{
    public UserNotRegistered(Exception e) {
        super("User Not Registered, See the stack trace for more details"+e);
    }
}
