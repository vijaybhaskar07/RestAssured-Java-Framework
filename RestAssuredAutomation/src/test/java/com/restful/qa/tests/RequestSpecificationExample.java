package com.restful.qa.tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class RequestSpecificationExample {

    @Test
    public void testWithRequestSpec() {
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://api.restful-api.dev"); // Set base URI on the spec
        requestSpec.basePath("/objects"); // Set base path on the spec

        // Use the specification in the test
        given()
            .spec(requestSpec)
        .when()
            .get() // No extra path needed here, as /ping is the full path
        .then()
            .statusCode(200); // Ping usually returns 201 Created
    }

    @Test
    public void testAnotherEndpoint() {
        // You can have a different spec for a different endpoint
        RequestSpecification anotherSpec = RestAssured.given();
        anotherSpec.baseUri("https://api.restful-api.dev").basePath("/objects/7");

        given()
            .spec(anotherSpec)
        .when()
            .get()
        .then()
            .statusCode(200)
            .body("name", equalTo("Apple MacBook Pro 16"));
    }
}

