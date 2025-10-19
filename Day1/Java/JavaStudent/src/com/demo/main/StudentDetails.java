package com.demo.main;

import java.io.Serializable;

public class StudentDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private int rollno;
    private String sname;
    private String course;
    private double attendance_percentage;
    private double score;

    // Default Constructor
    public StudentDetails() {}

    // Parameterized Constructor
    public StudentDetails(int rollno, String sname, String course, double attendance_percentage, double score)
            throws LowAttendanceException {
        this.rollno = rollno;
        this.sname = sname;
        this.course = course;
        this.attendance_percentage = attendance_percentage;
        this.score = score;

        if (attendance_percentage < 60) {
            throw new LowAttendanceException("Attendance below 60% for student: " + sname + " (roll: " + rollno + ")");
        }
    }

    // Method to calculate grade
    public String calculateGrade() {
        if (score >= 90) return "A+";
        else if (score >= 80) return "A";
        else if (score >= 70) return "B";
        else if (score >= 60) return "C";
        else return "F";
    }

    public double getAttendance() {
        return attendance_percentage;
    }

    public int getRollno() {
        return rollno;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollno + ", Name: " + sname + ", Course: " + course +
                ", Attendance: " + attendance_percentage + "%, Score: " + score +
                ", Grade: " + calculateGrade();
    }
}
