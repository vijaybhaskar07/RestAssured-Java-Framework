package com.restful.qa.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GlobalSettingsExample {

	@BeforeClass
	public static void setUp() {

		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.basePath = "/objects";

	}

	@Test
	public void testGetObject() {

		given().when().get("/7").then().statusCode(200).log().all();
	}

}
