package APITest;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create {

	// Test 1: Test for Creating user
	@Test
	public void CreateBooking() {
		int random = GetRandomNo();
		RestAssured.baseURI = "https://api.m3o.com/v1/user/";
		RequestSpecification httpRequest = RestAssured.given();

		// Passing the data to be updated
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Authorization", "Bearer ZjVjYTRhYzQtMThiYi00ZjlhLTk2ZGQtNmZlODY0MTQ1Yzli");

		httpRequest.body(GetBookingData(random + 6).toString());
		Response response = httpRequest.request(Method.POST, "Create");

		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);

		httpRequest.body(DeleteUserData(random).toString());
		httpRequest.request(Method.POST, "Delete");

	}

	// Test 2: Test for Updating user Information
	@Test
	public void UpdateUser() {
		int random = GetRandomNo();
		RestAssured.baseURI = "https://api.m3o.com/v1/user/";
		RequestSpecification httpRequest = RestAssured.given();

		// Passing the data to be updated
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Authorization", "Bearer ZjVjYTRhYzQtMThiYi00ZjlhLTk2ZGQtNmZlODY0MTQ1Yzli");

		httpRequest.body(GetBookingData(random).toString());
		Response response = httpRequest.request(Method.POST, "Create");

		httpRequest.body(UpdateUserData(random).toString());
		Response response1 = httpRequest.request(Method.POST, "Update");

		int statusCode = response1.getStatusCode();
		assertEquals(statusCode, 200);

	}

	// Test 3: Test for deletion of user profile
	@Test
	public void DeleteUser() {
		int random = GetRandomNo();
		RestAssured.baseURI = "https://api.m3o.com/v1/user/";
		RequestSpecification httpRequest = RestAssured.given();

		// Passing the data to be updated
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Authorization", "Bearer ZjVjYTRhYzQtMThiYi00ZjlhLTk2ZGQtNmZlODY0MTQ1Yzli");

		httpRequest.body(GetBookingData(random).toString());
		Response response = httpRequest.request(Method.POST, "Create");

		httpRequest.body(DeleteUserData(random).toString());
		Response response1 = httpRequest.request(Method.POST, "Delete");

		int statusCode = response1.getStatusCode();
		assertEquals(statusCode, 200);

	}

	public int GetRandomNo() {
		return (int) Math.random();
	}

	public JSONObject GetBookingData(int random) {

		JSONObject request = new JSONObject();
		request.put("email", "Test" + random + "@example.com");
		request.put("id", "Test-" + random);
		request.put("password", "mySecretPass" + random);
		request.put("username", "Test-" + random);
		return request;
	}

	public JSONObject UpdateUserData(int random) {
		JSONObject request = new JSONObject();
		request.put("email", "Test" + random + "@example.com");
		request.put("id", "Test-" + random);
		request.put("username", "Test" + random);
		return request;
	}

	public JSONObject DeleteUserData(int random) {
		JSONObject request = new JSONObject();
		request.put("id", "Test-" + random);
		return request;
	}

}
