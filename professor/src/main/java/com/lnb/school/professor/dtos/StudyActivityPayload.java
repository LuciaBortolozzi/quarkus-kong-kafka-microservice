package com.lnb.school.professor.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudyActivityPayload {
    private List<String> sidn;
    private String pidn;
    private String studyName;
    private String studyStartTime;
    private String studyEndTime;

    public List<String> getSidn() {
        return sidn;
    }

    public void setSidn(List<String> sidn) {
        this.sidn = sidn;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getStudyStartTime() {
        return studyStartTime;
    }

    public void setStudyStartTime(String studyStartTime) {
        this.studyStartTime = studyStartTime;
    }

    public String getStudyEndTime() {
        return studyEndTime;
    }

    public void setStudyEndTime(String studyEndTime) {
        this.studyEndTime = studyEndTime;
    }

    public String getPidn() {
        return pidn;
    }

    public void setPidn(String pidn) {
        this.pidn = pidn;
    }
}
