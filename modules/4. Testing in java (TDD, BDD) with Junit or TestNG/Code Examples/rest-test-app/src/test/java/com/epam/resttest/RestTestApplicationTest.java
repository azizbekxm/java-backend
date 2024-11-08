package com.epam.resttest;

import com.epam.restservice.jpa.Employee;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RestServiceApplicationTest {

	private String employeeLoad = "{\n" +
			"  \"email\": \"ivan.spresov@gmail.com\",\n" +
			"  \"firstName\": \"Ivan\",\n" +
			"  \"lastName\": \"Spresov\"\n" +
			"}";

	private Gson gson = new Gson();
	private Long id = 1l;

	@BeforeEach
	public void configureRestAssured(){
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON).body(employeeLoad);
		Response response = httpRequest.post("/employees");
		ResponseBody body = response.getBody();
		Employee e = gson.fromJson(body.asString(), Employee.class);
		id = e.getId();
	}

	@AfterEach
	public void clearRestAssured(){
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("/employees/{id}", id);
	}

	@Test
	public void testCreateEmployee() {
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON).body(employeeLoad);
		Response response = httpRequest.post("/employees");
		ResponseBody body = response.getBody();
		Employee e = gson.fromJson(body.asString(), Employee.class);
		assertEquals("Ivan", e.getFirstName());
	}

	@Test
	public void testResponseData() {
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/employees");
		ResponseBody body = response.getBody();
		List employees = gson.fromJson(body.asString(), List.class);
		Object obj = employees.get(0);
		Employee e = gson.fromJson(obj.toString(), Employee.class);
		assertEquals("Ivan", e.getFirstName());
	}

	@Test
	public void testGetEmployeeById() {
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/employees/{id}", id);
		ResponseBody body = response.getBody();
		Employee e = gson.fromJson(body.asString(), Employee.class);
		assertEquals("Ivan", e.getFirstName());
	}

	@Test
	public void testUpdateEmployee() {
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON).body(employeeLoad);
		Response response = httpRequest.put("/employees/{id}", id);
		ResponseBody body = response.getBody();
		Employee e = gson.fromJson(body.asString(), Employee.class);
		assertEquals("Ivan", e.getFirstName());
	}

	@Test
	public void testDeleteEmployee() {
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("/employees/{id}", id);
		ResponseBody body = response.getBody();
		assertEquals("", body.asString());

	}

	@Test
	public void testDeleteAll() {
		RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.delete("/employees");
		ResponseBody body = response.getBody();
		assertEquals("", body.asString());

	}

}
