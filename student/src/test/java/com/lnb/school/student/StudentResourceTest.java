package com.lnb.school.student;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class StudentResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/v1/students")
          .then()
             .statusCode(404);
    }

}