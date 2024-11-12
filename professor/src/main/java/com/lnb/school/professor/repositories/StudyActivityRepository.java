package com.lnb.school.professor.repositories;

import com.lnb.school.professor.models.StudyActivity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudyActivityRepository implements PanacheRepository<StudyActivity> {

}
