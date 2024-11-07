package com.lnb.school.professor.services;

import com.lnb.school.professor.dtos.ProfessorRequestDto;
import com.lnb.school.professor.models.Professor;
import com.lnb.school.professor.repositories.ProfessorRepository;

import static com.lnb.school.professor.utils.Constants.BAD_REQUEST;
import static com.lnb.school.professor.utils.Constants.CODE_200_VAL;
import static com.lnb.school.professor.utils.Constants.CODE_201_VAL;
import static com.lnb.school.professor.utils.Constants.CODE_KEY;
import static com.lnb.school.professor.utils.Constants.DATA_KEY;
import static com.lnb.school.professor.utils.Constants.DATA_NOT_FOUND;
import static com.lnb.school.professor.utils.Constants.MESSAGE_KEY;
import static com.lnb.school.professor.utils.Constants.MESSAGE_VAL;

import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;

@ApplicationScoped
public class ProfessorService {
    ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Transactional
    public JsonObject saveProfessor(ProfessorRequestDto req) throws ValidationException {
        if (req == null)
            throw new ValidationException(BAD_REQUEST);

        Professor professor = new Professor();
        professor.pidn = req.getPidn();
        professor.name = req.getName();
        professor.email = req.getEmail();
        professor.phone = req.getPhone();
        professor.major = req.getMajor();
        professorRepository.persist(professor);

        JsonObject resp = new JsonObject();
        resp.put(CODE_KEY, CODE_201_VAL);
        resp.put(MESSAGE_KEY, MESSAGE_VAL);

        return resp;
    }

    @Transactional
    public JsonObject updateProfessor(ProfessorRequestDto req, Long id) throws ValidationException {
        if (req == null)
            throw new ValidationException(BAD_REQUEST);

        Professor professor = professorRepository.findById(id);
        if (professor == null)
            throw new ValidationException(DATA_NOT_FOUND);

        professorRepository.update("pidn = ?1, name = ?2, email = ?3, phone = ?4, major = ?5 where id = ?6",
                req.getPidn(),
                req.getName(), req.getEmail(), req.getPhone(), req.getMajor(), id);

        JsonObject resp = new JsonObject();
        resp.put(CODE_KEY, CODE_200_VAL);
        resp.put(MESSAGE_KEY, MESSAGE_VAL);

        return resp;
    }

    public JsonObject getListProfessor() {
        JsonObject resp = new JsonObject();
        resp.put(CODE_KEY, CODE_200_VAL);
        resp.put(MESSAGE_KEY, MESSAGE_VAL);
        resp.put(DATA_KEY, professorRepository.listAll());

        return resp;
    }

    public JsonObject getProfessorByID(Long id) {
        JsonObject resp = new JsonObject();
        resp.put(CODE_KEY, CODE_200_VAL);
        resp.put(MESSAGE_KEY, MESSAGE_VAL);
        resp.put(DATA_KEY, professorRepository.findById(id));

        return resp;
    }

    public JsonObject getProfessorByPidn(String pidn) {
        JsonObject resp = new JsonObject();
        resp.put(CODE_KEY, CODE_200_VAL);
        resp.put(MESSAGE_KEY, MESSAGE_VAL);
        resp.put(DATA_KEY, professorRepository.findByPidn(pidn));

        return resp;
    }

    @Transactional
    public JsonObject deleteProfessor(Long id) throws ValidationException {
        if (id == null)
            throw new ValidationException(BAD_REQUEST);

        Professor professor = professorRepository.findById(id);
        if (professor != null)
            professorRepository.delete(professor);

        JsonObject resp = new JsonObject();
        resp.put(CODE_KEY, CODE_200_VAL);
        resp.put(MESSAGE_KEY, MESSAGE_VAL);

        return resp;
    }
}