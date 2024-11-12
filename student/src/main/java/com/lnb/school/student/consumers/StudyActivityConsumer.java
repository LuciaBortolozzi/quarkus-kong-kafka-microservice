package com.lnb.school.student.consumers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.lnb.school.student.dtos.StudyActivityPayload;
import com.lnb.school.student.models.StudyActivity;
import com.lnb.school.student.repositories.StudyActivityRepository;
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
    public void saveStudyActivity(String message) throws JsonProcessingException {
        final StudyActivityPayload studyActivityPayload = objectMapper.readValue(message, StudyActivityPayload.class);
        studyActivityPayload.getSidn().stream().forEach((var sidn) -> {
            StudyActivity sa = new StudyActivity();
            sa.sidn = sidn;
            sa.pidn = studyActivityPayload.getPidn();
            sa.studyName = studyActivityPayload.getPidn();
            try {
                sa.studyStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .parse(studyActivityPayload.getStudyStartTime());
                sa.studyEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .parse(studyActivityPayload.getStudyEndTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            studyActivityRepository.persist(sa);
        });
    }
}
