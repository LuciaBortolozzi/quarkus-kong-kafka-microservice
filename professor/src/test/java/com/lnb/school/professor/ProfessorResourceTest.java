package com.lnb.school.professor;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyArray;

import com.lnb.school.professor.dtos.ProfessorRequestDto;

@QuarkusTest
class ProfessorResourceTest {

    @Test
    void testAddProfessor() {
        ProfessorRequestDto request = new ProfessorRequestDto();
        request.setPidn("P12345");
        request.setName("Minerva McGonagall");
        request.setEmail("minerva.mcgonagall@hogwarts.edu");
        request.setPhone("321-654-9870");
        request.setMajor("Transfiguration");

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/v1/professors")
                .then()
                .statusCode(201)
                .body("name", is("Minerva McGonagall"))
                .body("pidn", is("P12345"))
                .body("email", is("minerva.mcgonagall@hogwarts.edu"))
                .body("phone", is("321-654-9870"))
                .body("major", is("Transfiguration"));
    }

    @Test
    void testUpdateProfessor() {
        ProfessorRequestDto request = new ProfessorRequestDto();
        request.setPidn("P67890");
        request.setName("Severus Snape");
        request.setEmail("severus.snape@hogwarts.edu");
        request.setPhone("456-123-7890");
        request.setMajor("Potions");

        given()
                .contentType("application/json")
                .body(request)
                .when().put("/v1/professors/{id}", 1)
                .then()
                .statusCode(200)
                .body("status", equalTo("ok"))
                .body("name", equalTo("Severus Snape"))
                .body("pidn", equalTo("P67890"))
                .body("email", equalTo("severus.snape@hogwarts.edu"))
                .body("phone", equalTo("456-123-7890"))
                .body("major", equalTo("Potions"));
    }

    @Test
    void testGetListProfessor() {
        given().when().get("/v1/professors").then().statusCode(200).body(not(emptyArray()));
    }

    @Test
    void testGetProfessorByID() {
        long professorId = 1;

        given().when().get("/v1/professors/{id}", professorId).then().statusCode(200).body("id", equalTo(professorId));
    }

    @Test
    void testGetProfessorByPidn() {
        String pidn = "PIDN123";

        given().when().get("/v1/professors/pidn/{pidn}", pidn).then().statusCode(200).body("pidn", equalTo(pidn));
    }

    @Test
    void testDeleteProfessor() {
        long professorId = 1;

        given().when().delete("/v1/professors/{id}", professorId).then().statusCode(200).body("status", equalTo("ok"));
    }
}
