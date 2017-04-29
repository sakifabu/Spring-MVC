package com.spring.Service;

import com.spring.Model.TeacherProject;
import com.spring.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Brian on 4/28/2017.
 */
@Service
public class ProjectService {
    /*
    public void run(String... args) throws Exception {

    }*/
    @Autowired
    public ProjectRepository repository;

    public void addNew(TeacherProject teacher){
        System.out.println(repository);
        repository.save(new TeacherProject(teacher.getName(), teacher.getIsElective(), teacher.getGradeExpected(),
                teacher.getCourseQuality(), teacher.getProfessorQuality(), teacher.getExampleEffectiveness(),
                teacher.getVisualSkill(), teacher.getRealLifePracticality()));
    }
}
