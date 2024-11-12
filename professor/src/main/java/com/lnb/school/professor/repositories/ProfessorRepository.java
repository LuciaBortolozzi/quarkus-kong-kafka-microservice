package com.lnb.school.professor.repositories;

import com.lnb.school.professor.models.Professor;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor> {
    public Professor findByPidn(String pidn) {
        return find("pidn = ?1", pidn).firstResult();
    }
}