package com.lnb.school.professor.consumers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.lnb.school.professor.dtos.StudyActivityPayload;
import com.lnb.school.professor.models.StudyActivity;
import com.lnb.school.professor.repositories.StudyActivityRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudyActivityConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    StudyActivityRepository studyActivityRepository;

    @Inject
    public StudyActivityConsumer(StudyActivityRepository studyActivityRepository) {
        this.studyActivityRepository = studyActivityRepository;
    }

    @Incoming("study-activity")
    @Transactional(Transactional.TxType.REQUIRED)
    public void saveStudyActivity(String message) throws JsonProcessingException, ParseException {
        final StudyActivityPayload studyActivityPayload = objectMapper.readValue(message, StudyActivityPayload.class);
        StudyActivity sa = new StudyActivity();
        sa.sidn = studyActivityPayload.getSidn();
        sa.pidn = studyActivityPayload.getPidn();
        sa.studyName = studyActivityPayload.getPidn();
        sa.studyStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(studyActivityPayload.getStudyStartTime());
        sa.studyEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .parse(studyActivityPayload.getStudyEndTime());
        studyActivityRepository.persist(sa);
    }
}
