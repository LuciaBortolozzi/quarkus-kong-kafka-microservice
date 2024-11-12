package com.lnb.school.study;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyArray;

import java.time.LocalDate;
import java.util.List;

import com.lnb.school.study.dtos.StudyRequestDto;

@QuarkusTest
class StudyResourceTest {

    @Test
    void testAddStudy() {
        StudyRequestDto request = new StudyRequestDto();
        request.setStudyName("Potions 101");
        request.setStudyDescription("Introduction to Potion Making");
        request.setStudyDate(LocalDate.now().toString());
        request.setPidn("P12345");
        request.setSidn(List.of("S12345"));

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/v1/studies")
                .then()
                .statusCode(201)
                .body("studyName", is("Potions 101"))
                .body("studyDescription", is("Introduction to Potion Making"))
                .body("pidn", is("P12345"))
                .body("sidn", is(List.of("S12345")));
    }

    @Test
    void testUpdateStudy() {
        StudyRequestDto request = new StudyRequestDto();
        request.setStudyName("Defense Against the Dark Arts");
        request.setStudyDescription("Advanced Defense Techniques");
        request.setStudyDate(LocalDate.now().toString());
        request.setPidn("P67890");
        request.setSidn(List.of("S67890"));

        String studyId = "1";

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .put("/v1/studies/{id}", studyId)
                .then()
                .statusCode(200)
                .body("studyName", is("Defense Against the Dark Arts"))
                .body("studyDescription", is("Advanced Defense Techniques"))
                .body("pidn", is("P67890"))
                .body("sidn", is(List.of("S67890")));
    }

    @Test
    void testGetStudyByID() {
        String studyId = "1";

        given()
                .when()
                .get("/v1/studies/{id}", studyId)
                .then()
                .statusCode(200)
                .body("studyName", is("Defense Against the Dark Arts"))
                .body("studyDescription", is("Advanced Defense Techniques"))
                .body("pidn", is("P67890"))
                .body("sidn", is(List.of("S67890")));
    }

    @Test
    void testGetListStudy() {
        given()
                .when()
                .get("/v1/studies")
                .then()
                .statusCode(200)
                .body("studies", is(not(emptyArray())));
    }

    @Test
    void testDeleteStudy() {
        String studyId = "1";

        given()
                .when()
                .delete("/v1/studies/{id}", studyId)
                .then()
                .statusCode(200)
                .body("status", is("ok"));
    }
}