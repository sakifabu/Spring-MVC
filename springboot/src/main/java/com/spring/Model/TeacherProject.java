package com.spring.Model;

import org.springframework.data.annotation.Id;

/**
 * Created by Brian on 4/27/2017.
 */
public class TeacherProject {
    @Id
    private String id;

    private String name;
    private double isElective;
    private double gradeExpected;
    private double courseQuality;
    private double professorQuality;
    private double exampleEffectiveness;
    private double visualSkill;
    private double realLifePracticality;

    public TeacherProject(String name, double isElective, double gradeExpected, double courseQuality,
                          double professorQuality, double exampleEffectiveness, double visualSkill, double realLifePracticality){
        this.setName(name);
        this.setIsElective(isElective);
        this.setGradeExpected(gradeExpected);
        this.setCourseQuality(courseQuality);
        this.setProfessorQuality(professorQuality);
        this.setExampleEffectiveness(exampleEffectiveness);
        this.setVisualSkill(visualSkill);
        this.setRealLifePracticality(realLifePracticality);
    }
    public TeacherProject(){}
    @Override
    public String toString() {
        return String.format(
                "TeacherProject[name=%s, isElective='%s', courseQuality='%s', professorQuality='%s'," +
                        "exampleEffectiveness='%s', visualSkill='%s', realLifePracticality='%s']",
                getName(), getIsElective(), getCourseQuality(), getProfessorQuality(), getExampleEffectiveness(), getVisualSkill(), getRealLifePracticality());

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIsElective() {
        return isElective;
    }

    public void setIsElective(double isElective) {
        this.isElective = isElective;
    }

    public double getGradeExpected() {
        return gradeExpected;
    }

    public void setGradeExpected(double gradeExpected) {
        this.gradeExpected = gradeExpected;
    }

    public double getCourseQuality() {
        return courseQuality;
    }

    public void setCourseQuality(double courseQuality) {
        this.courseQuality = courseQuality;
    }

    public double getProfessorQuality() {
        return professorQuality;
    }

    public void setProfessorQuality(double professorQuality) {
        this.professorQuality = professorQuality;
    }

    public double getExampleEffectiveness() {
        return exampleEffectiveness;
    }

    public void setExampleEffectiveness(double exampleEffectiveness) {
        this.exampleEffectiveness = exampleEffectiveness;
    }

    public double getVisualSkill() {
        return visualSkill;
    }

    public void setVisualSkill(double visualSkill) {
        this.visualSkill = visualSkill;
    }

    public double getRealLifePracticality() {
        return realLifePracticality;
    }

    public void setRealLifePracticality(double realLifePracticality) {
        this.realLifePracticality = realLifePracticality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
