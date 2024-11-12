package com.lnb.school.study.repositories;

import com.lnb.school.study.model.Study;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudyRepository implements PanacheMongoRepository<Study> {

}
