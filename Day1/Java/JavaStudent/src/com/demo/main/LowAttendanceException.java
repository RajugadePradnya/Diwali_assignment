package com.demo.main;

public class LowAttendanceException extends Exception {
    private static final long serialVersionUID = 1L;

    public LowAttendanceException(String message) {
        super(message);
    }
}
