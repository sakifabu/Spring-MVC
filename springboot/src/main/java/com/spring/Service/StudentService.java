package com.spring.Service;

import com.spring.Model.Student;
import com.spring.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Brian on 4/24/2017.
 */

//Same thing as repository
@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Collection<Student> getAllStudents(){
        return this.studentRepo.getAllStudents();
    }
    public Student getStudentById(int id){
        return this.studentRepo.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.studentRepo.removeStudentById(id);
    }

    public void updateStudent(Student student){
        this.studentRepo.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentRepo.insertStudent(student);
    }
}
