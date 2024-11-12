package com.lnb.school.study.repositories;

import com.lnb.school.study.model.Student;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentRepository implements PanacheMongoRepository<Student> {

}
