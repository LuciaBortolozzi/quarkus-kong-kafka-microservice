package com.lnb.school.professor;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ProfessorResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/professors")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}