package com.collabor8.exception;

public class UserNotUpdatedException extends RuntimeException {
    public UserNotUpdatedException(Exception e) {
        super("User Not updated successfully, See the stack trace for more details: "+e);
    }
}
