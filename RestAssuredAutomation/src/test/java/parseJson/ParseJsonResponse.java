package parseJson;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParseJsonResponse {
	
	@Test
	public void testJsonResponse1() {
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("data[5].email", equalTo("rachel.howell@reqres.in"));
	}
	
	@Test
	public void testJsonResponse2() {
		
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=2");
		Assert.assertEquals(res.statusCode(), 200);
		String email = res.jsonPath().get("data[5].email").toString();
		Assert.assertEquals(email, "rachel.howell@reqres.in");
				
		
	}
	
	@Test
	public void testJsonResponse3() {
		
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=2");
		
		JSONObject jo = new JSONObject(res.asString());
		
		for(int i=0; i<jo.getJSONArray("data").length(); i++) {
			String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(email);
		}
		
	}
	 
	

	
}
