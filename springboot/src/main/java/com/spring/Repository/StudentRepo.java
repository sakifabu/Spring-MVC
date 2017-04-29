package com.spring.Repository;

import com.spring.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian on 4/24/2017.
 */
//Let spring know this is a repository not a component
@Repository
public class StudentRepo {

    private static Map<Integer, Student> students;

    static{
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Brian", "Emerging Issues"));
                put(2, new Student(2, "Abu", "Emerging Issues"));
                put(3, new Student(3, "Elaine", "Emerging Issues"));
            }
        };
    }
    public Collection<Student> getAllStudents(){
        return  this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student student){
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    public void insertStudent(Student student) {
        this.students.put(student.getId(),student);
    }
}
