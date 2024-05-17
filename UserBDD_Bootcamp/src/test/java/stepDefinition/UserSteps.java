package stepDefinition;


import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.json.JSONException;
import utilities.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



import utilities.Utils;

public class UserSteps extends Utils{
	RequestSpecification requestSpec;	
	ResponseSpecification responseSpec;
	Response response;
	
	@Given("Get user  with valid data")
	public void get_user_with_valid_data() throws JSONException, IOException {		
		requestSpec = given().spec(requestSpecification());

	}
	@Given("Create user with valid payload")
	public void create_user_with_valid_payload() throws JSONException, IOException {
		String jsonFileName = "userdata.json";
		String jsonKey = "postuser";
		
		requestSpec = given().spec(requestSpecification().body(JsonReader.getRequestBody(jsonFileName,jsonKey)));
		

	}
	@When("user calls {string} with {string} request")
	public void user_calls_with_request(String path, String request) {
		 
		
	}  
		     
			
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}
	
	@Then ("user created with status code {int}")
	public void user_created_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 201);
	}



}
