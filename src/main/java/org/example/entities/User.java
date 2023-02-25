package org.example.entities;

public class User {
    private String subject;
    private String midTermGrade;
    private String endTermGrades;
    private String finalGrades;
    private String attendance;

    public User(String nameOfSubject, String attendance, String midTerm, String endTerm, String finalExam) {
        setSubject(nameOfSubject);
        setMidTermGrade(midTerm);
        setEndTermGrades(endTerm);
        setAttendance(attendance);
        setFinalGrades(finalExam);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public void setEndTermGrades(String endTermGrades) {
        this.endTermGrades = endTermGrades;
    }

    public void setMidTermGrade(String midTermGrade) {
        this.midTermGrade = midTermGrade;
    }

    public void setFinalGrades(String finalGrades) {
        this.finalGrades = finalGrades;
    }

    public String getSubject() {
        return subject;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getEndTermGrades() {
        return endTermGrades;
    }

    public String getFinalGrades() {
        return finalGrades;
    }

    public String getMidTermGrade() {
        return midTermGrade;
    }
}
