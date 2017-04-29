package com.spring.Repository;

import com.spring.Model.TeacherProject;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Brian on 4/28/2017.
 */
public interface ProjectRepository extends MongoRepository<TeacherProject, String> {
    public List<TeacherProject> findByName(String name);
}
