package com.lnb.school.professor.repositories;

import com.lnb.school.professor.models.Professor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor> {
    public Professor findByLidn(String lidn) {
        return find("lidn = ?1", lidn).firstResult();
    }
}