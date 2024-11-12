package com.lnb.school.student.repositories;

import com.lnb.school.student.models.StudyActivity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudyActivityRepository implements PanacheRepository<StudyActivity> {

}
