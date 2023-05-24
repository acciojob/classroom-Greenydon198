package com.driver;

import java.util.List;

public class StudentService {

    StudentRepository sr = new StudentRepository();
    public void addStudent(Student student) {
        sr.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        sr.addTeacher(teacher);
    }

    public Teacher getTeacherByName(String name) {
        return sr.getTeacherByName(name);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        sr.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name) {
        return sr.getStudentByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return sr.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return sr.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        sr.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        sr.deleteAllTeachers();
    }
}
