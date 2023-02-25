package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public void print() {
        for (User user : users) {
            System.out.println(user.getSubject() + "\n" +
                            "Attendance: " + user.getAttendance() + "\n" +
                            "MidTerm: " + user.getMidTermGrade() + "\n" +
                    "EndTerm: " + user.getEndTermGrades() + "\n" +
                    "Final Exam: " + user.getFinalGrades()
                    );
        }
    }

    public void add(User user) {
        users.add(user);
    }
}
