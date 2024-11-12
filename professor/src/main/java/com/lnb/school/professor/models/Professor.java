package com.lnb.school.professor.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @SequenceGenerator(name = "professorSequence", sequenceName = "professor_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professorSequence")
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "pidn", length = 16, nullable = false)
    public String pidn; // Professor ID Number

    @Column(name = "name", length = 100, nullable = false)
    public String name;

    @Column(name = "email", length = 100, nullable = false)
    public String email;

    @Column(name = "phone", length = 20, nullable = false)
    public String phone;

    @Column(name = "major", length = 100, nullable = false)
    public String major;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    public Date createdAt;
}