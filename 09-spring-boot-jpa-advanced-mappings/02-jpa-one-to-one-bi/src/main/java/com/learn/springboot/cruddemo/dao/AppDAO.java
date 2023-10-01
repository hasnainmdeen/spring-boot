package com.learn.springboot.cruddemo.dao;

import com.learn.springboot.cruddemo.entity.Instructor;
import com.learn.springboot.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
