package com.lnb.school.study.dtos;

import java.util.List;

public class StudyRequestDto {
    private String studyName;
    private String studyDescription;
    private String studyDate;
    private String pidn;
    private List<String> sidn;

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getStudyDescription() {
        return studyDescription;
    }

    public void setStudyDescription(String studyDescription) {
        this.studyDescription = studyDescription;
    }

    public String getPidn() {
        return pidn;
    }

    public void setPidn(String pidn) {
        this.pidn = pidn;
    }

    public List<String> getSidn() {
        return sidn;
    }

    public void setSidn(List<String> sidn) {
        this.sidn = sidn;
    }

    public String getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(String studyDate) {
        this.studyDate = studyDate;
    }
}
