package com.lnb.school.student;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyArray;

import com.lnb.school.student.dtos.StudentRequestDto;

@QuarkusTest
class StudentResourceTest {

    @Test
    void testAddStudent() {
        StudentRequestDto request = new StudentRequestDto();
        request.setSidn("S12345");
        request.setName("Harry Potter");
        request.setEmail("harry.potter@hogwarts.edu");
        request.setPhone("321-654-9870");

        given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/v1/students")
                .then()
                .statusCode(201)
                .body("name", is("Harry Potter"))
                .body("sidn", is("S12345"))
                .body("email", is("harry.potter@hogwarts.edu"))
                .body("phone", is("321-654-9870"));
    }

    @Test
    void testUpdateStudent() {
        StudentRequestDto request = new StudentRequestDto();
        request.setSidn("S67890");
        request.setName("Hermione Granger");
        request.setEmail("hermione.granger@hogwarts.edu");
        request.setPhone("456-123-7890");

        given()
                .contentType("application/json")
                .body(request)
                .when().put("/v1/students/{id}", 1)
                .then()
                .statusCode(200)
                .body("status", equalTo("ok"))
                .body("name", equalTo("Hermione Granger"))
                .body("sidn", equalTo("S67890"))
                .body("email", equalTo("hermione.granger@hogwarts.edu"))
                .body("phone", equalTo("456-123-7890"));
    }

    @Test
    void testGetListStudent() {
        given().when().get("/v1/students").then().statusCode(200).body(not(emptyArray()));
    }

    @Test
    void testGetStudentByID() {
        long studentId = 1;

        given().when().get("/v1/students/{id}", studentId).then().statusCode(200).body("id", equalTo(studentId));
    }

    @Test
    void testGetStudentBySidn() {
        String sidn = "SIDN123";

        given().when().get("/v1/students/sidn/{sidn}", sidn).then().statusCode(200).body("sidn", equalTo(sidn));
    }

    @Test
    void testDeleteStudent() {
        long studentId = 1;

        given().when().delete("/v1/students/{id}", studentId).then().statusCode(200).body("status", equalTo("ok"));
    }

}