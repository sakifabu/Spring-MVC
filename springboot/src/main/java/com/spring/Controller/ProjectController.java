package com.spring.Controller;

/**
 * Created by Brian on 4/27/2017.
 */
import com.spring.Model.ResultProject;
import com.spring.Model.SelectProject;
import com.spring.Model.Student;
import com.spring.Model.TeacherProject;
import com.spring.Repository.ProjectRepository;
import com.spring.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

@Controller
public class ProjectController {
    @Autowired
    private ProjectRepository repository;
    @Autowired
    private ProjectService serv;
    @GetMapping("/index")
    public String testingForm(){
        return "index";
    }

    @GetMapping("/poll")
    public String getPollDrops(Model model){
        model.addAttribute("select", new SelectProject());
        return "poll";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("teacher", new TeacherProject());
        return "create";
    }
    @PostMapping("/create")
    public String teacherSubmit(@ModelAttribute TeacherProject teacher){
        /*
        System.out.println("ITS HERE");
        try {
            System.out.println(teacher.getIsElective());
        }catch(Exception e){
            System.out.println("There's nothing in here");
        }
        */
        //Not good? ProjectService serv = new ProjectService();
        //System.out.println(teacher.getGradeExpected());
        serv.addNew(teacher);
        return "confirm";
    }
    //@ModelAttribute("student")
    @PostMapping("/getInfo")
    public ModelAndView getSubmit(@ModelAttribute SelectProject select){
        System.out.println(select.getNameSelected());
        ArrayList<Double> isElec = new ArrayList<>();
        ArrayList<Double> gradeEx = new ArrayList<>();
        ArrayList<Double> courseQu = new ArrayList<>();
        ArrayList<Double> profQu = new ArrayList<>();
        ArrayList<Double> exEff = new ArrayList<>();
        ArrayList<Double> vis = new ArrayList<>();
        ArrayList<Double> real = new ArrayList<>();

        repository.findByName(select.getNameSelected());
        for (TeacherProject teach : repository.findByName(select.getNameSelected())){
            System.out.println(teach.getName());
            isElec.add(teach.getIsElective());
            gradeEx.add(teach.getGradeExpected());
            courseQu.add(teach.getCourseQuality());
            profQu.add(teach.getProfessorQuality());
            exEff.add(teach.getExampleEffectiveness());
            vis.add(teach.getVisualSkill());
            real.add(teach.getRealLifePracticality());

        }
        ResultProject result = new ResultProject();
        result.setName(select.getNameSelected());
        //System.out.println(calcIsElective(isElec));
        result.setIsElective(calcIsElective(isElec));
        result.setTheGrade(calcGrade(gradeEx));
        result.setCourseQuality(calcCourseQu(courseQu));
        result.setProfessorQuality(calcProf(profQu));
        result.setExampleEffectiveness(calcEx(exEff));
        result.setVisualSkill(calcVis(vis));
        result.setRealLifePracticality(calcReal(real));
        ModelAndView mav = new ModelAndView("allResults", "something", result);
        return mav;
    }
    //Defining average of real life practicality rating
    public double calcReal(ArrayList<Double> real){
        double sum = 0;
        for(int i = 0; i < real.size(); i++){
            sum += real.get(i);
        }
        double total = Math.round(sum/real.size() * 100);
        return (total/100);
    }
    //Defining average of visual skills
    public double calcVis(ArrayList<Double> vis){
        double sum = 0;
        for(int i = 0; i < vis.size(); i++){
            sum += vis.get(i);
        }
        double total = Math.round(sum/vis.size() * 100);
        return (total/100);
    }
    //Defining average of example effectiveness
    public double calcEx(ArrayList<Double> exEff){
        double sum = 0;
        for(int i = 0; i < exEff.size(); i++){
            sum += exEff.get(i);
        }
        double total = Math.round(sum/exEff.size() * 100);
        return (total/100);
    }
    //Defining average of professor quality
    public double calcProf(ArrayList<Double> profQu){
        double sum = 0;
        for(int i = 0; i < profQu.size(); i++){
            sum += profQu.get(i);
        }
        double total = Math.round(sum/profQu.size() * 100);
        return (total/100);
    }
    //Defining average of course quality
    public double calcCourseQu(ArrayList<Double> courseQu){
        double sum = 0;
        for(int i = 0; i < courseQu.size(); i++){
            sum += courseQu.get(i);
        }
        double total = Math.round(sum/courseQu.size() * 100);
        return (total/100);
    }
    //Defining calculations for whether or not the courses were electives
    public double calcIsElective(ArrayList<Double> isElec){
        double sum = 0;
        for(int i = 0; i < isElec.size(); i++){
            sum += isElec.get(i);
        }
        double total = Math.round(sum/isElec.size() * 100);
        return (total);
    }
    public String calcGrade(ArrayList<Double> gradeEx){
        double sum = 0;
        String grade;
        for(int i = 0; i < gradeEx.size(); i++){
            sum += gradeEx.get(i);
        }
        double total = sum/gradeEx.size();
        if (total >= 3.7){
            grade = "A";
        }
        else if (total < 3.7 && total >= 2.7){
            grade = "B";
        }
        else if (total < 2.7 && total >= 1.7){
            grade = "C";
        }
        else if (total < 1.7 && total >= 1.0){
            grade = "D";
        }
        else{
            grade = "F";
        }
        return grade;
    }
}
