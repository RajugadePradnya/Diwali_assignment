package com.demo.main;

import java.io.*;
import java.util.*;

public class Student {
    public static void main(String[] args) {
        List<StudentDetails> studentList = new ArrayList<>();

        // Create and add 10 students — each inside its own try so one bad student won't stop others
        addStudentSafely(studentList, 1, "Anjali", "ENTC", 92, 88);
        addStudentSafely(studentList, 2, "Ritesh", "IT", 85, 78);
        addStudentSafely(studentList, 3, "Priti", "CSE", 75, 90);
        addStudentSafely(studentList, 4, "Amit", "EEE", 55, 60); // will be reported but won't stop others
        addStudentSafely(studentList, 5, "Pradnya", "ENTC", 88, 70);
        addStudentSafely(studentList, 6, "Rohan", "CSE", 95, 95);
        addStudentSafely(studentList, 7, "Harry", "IT", 67, 80);
        addStudentSafely(studentList, 8, "Archana", "CIVIL", 77, 65);
        addStudentSafely(studentList, 9, "Sujit", "EEE", 82, 72);
        addStudentSafely(studentList, 10, "Sayli", "ENTC", 90, 85);

        // Serialize student objects into a file
        String filename = "students.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(studentList);
            System.out.println("\n✅ Students serialized successfully to '" + filename + "'\n");
        } catch (IOException e) {
            System.err.println("Serialization error:");
            e.printStackTrace();
        }

        // Sort students in decreasing order of attendance.
        // Use comparator with tie-breaker on rollno to avoid TreeSet merging equal-attendance entries.
        Comparator<StudentDetails> attendanceComparator =
                Comparator.comparingDouble(StudentDetails::getAttendance).reversed()
                          .thenComparingInt(StudentDetails::getRollno);

        TreeSet<StudentDetails> sortedStudents = new TreeSet<>(attendanceComparator);
        sortedStudents.addAll(studentList);

        System.out.println("📋 Students sorted by decreasing attendance:\n");
        for (StudentDetails s : sortedStudents) {
            System.out.println(s);
        }

        // Optional: deserialize back and display (verification)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                @SuppressWarnings("unchecked")
                List<StudentDetails> deserialized = (List<StudentDetails>) obj;
                System.out.println("\n📂 Deserialized Students from file:\n");
                deserialized.forEach(System.out::println);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error:");
            e.printStackTrace();
        }
    }

    // helper to add each student in isolated try-catch
    private static void addStudentSafely(List<StudentDetails> list, int roll, String name, String course,
                                         double attendance, double score) {
        try {
            list.add(new StudentDetails(roll, name, course, attendance, score));
        } catch (LowAttendanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
