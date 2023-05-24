package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentRepository {

    HashMap<String,Student> students;
    HashMap<String,Teacher> teachers;
    HashMap<String,ArrayList<String>> pair;

    public StudentRepository(){
        students = new HashMap<>();
        teachers = new HashMap<>();
        pair = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getName(),teacher);
    }

    public Teacher getTeacherByName(String name) {
        return teachers.get(name);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        if(teachers.containsKey(teacher) && students.containsKey(student)){
            ArrayList<String> list = pair.getOrDefault(teacher,new ArrayList<>());
            list.add(student);
            pair.put(teacher,list);
        }
    }

    public Student getStudentByName(String name) {
        return students.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        if(pair.containsKey(teacher))
            return new ArrayList<>(pair.get(teacher));
        else
            return null;
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(students.keySet());
    }

    public void deleteTeacherByName(String teacher) {
        if(pair.containsKey(teacher)){
            for(String student:pair.get(teacher)){
                if(students.containsKey(student))
                    students.remove(student);
            }
            pair.remove(teacher);
            if(teachers.containsKey(teacher))teachers.remove(teacher);
        }
    }

    public void deleteAllTeachers() {
        ArrayList<String> temp = new ArrayList<>(pair.keySet());
        for(String teacher:temp){
            deleteTeacherByName(teacher);
        }
        pair = new HashMap<>();
        teachers = new HashMap<>();
    }
}
