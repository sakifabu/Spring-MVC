package com.spring.Model;

/**
 * Created by Brian on 4/24/2017.
 */
public class Student {
    private int id;
    private String name;
    private String course;

    public Student(int id, String name, String course){
        this.setId(id);
        this.setName(name);
        this.setCourse(course);
    }
    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
