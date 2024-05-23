package stepDefinition;


import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.json.JSONException;



import utilities.APIpath;
import utilities.JsonReader;
import utilities.PropertiesFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojos.UserTempData;
import utilities.Utils;


public class UserSteps extends Utils{
	RequestSpecification requestSpec;	
	ResponseSpecification responseSpec;
	Response response;	
	public static String actualcode;
	public static String actualmsg;
	
	//Post users- valid
	@Given("Create user with valid payload")
	public void create_user_with_valid_payload() throws JSONException, IOException {
		String jsonFileName ="userdata.json";
		String jsonKey ="postuser1";		
		requestSpec = given().spec(requestSpecification().body(JsonReader.getRequestBody(jsonFileName,jsonKey)));
	}
	
	@When("user calls {string} with {string} request")
	public void user_calls_with_request(String path, String request) throws IOException {
		  APIpath p = APIpath.valueOf(path);
		  System.out.println(p.getPath());
		  System.out.println("path:" + path);
		  System.out.println("REQUEST:" + request);
		     
			if(request.equalsIgnoreCase("post")) {
		    	  response = requestSpec.when().post(p.getPath()).then().extract().response();	    	  
		    	  JsonPath jsonPath = new JsonPath(response.getBody().asString());
		    	  UserTempData.userid = jsonPath.getInt("user_id");
		    	  UserTempData.firstname = jsonPath.get("user_first_name");
		    	  System.out.println(UserTempData.userid);
		    	  System.out.println(UserTempData.firstname);
		    	 
		   }
			 else if(request.equalsIgnoreCase("getusers"))
				  response = requestSpec.when().get(p.getPath());
			
			  else if(request.equalsIgnoreCase("getbyuserId")) 				  
				  response = requestSpec.when().get(p.getPath()+ UserTempData.userid);  			  		  
			
			  else if(request.equalsIgnoreCase("getbyusername"))
				  response = requestSpec.when().get(p.getPath()+ UserTempData.firstname);
			
			  else if(request.equalsIgnoreCase("put")) {				  
				  response = requestSpec.when().put(p.getPath()+ UserTempData.userid); 

				  }
			
			  else if(request.equalsIgnoreCase("deletebyuserId")) 				  
				  response = requestSpec.when().delete(p.getPath()+ UserTempData.userid);  			  		  
			
			  else if(request.equalsIgnoreCase("deletebyusername"))
				  response = requestSpec.when().delete(p.getPath()+ UserTempData.firstname);
		
	}  
	
	@Then ("user created with status code {int}")
	public void user_created_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 201);
	}
	
	//Get all users - valid
	@Given("Get user  with valid data")
	public void get_user_with_valid_data() throws JSONException, IOException {		
		requestSpec = given().spec(requestSpecification());

		}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}
	
	//Update user -valid	
	@Given("Update user with valid payload")
	public void update_user_with_valid_payload() throws JSONException, IOException {
		String jsonFileName ="userdata.json";
		String jsonKey ="updateuser1";		
		requestSpec = given().spec(requestSpecification().body(JsonReader.getRequestBody(jsonFileName,jsonKey)));
	}
	
	//Delete user - valid
	@Given("Delete user with valid userId")
	public void delete_user_with_valid_userid() throws JSONException, IOException {		
		requestSpec = given().spec(requestSpecification());

	}
	@Given("Delete user with valid userName")
	public void delete_user_with_valid_username() throws JSONException, IOException {		
		requestSpec = given().spec(requestSpecification());
	}
		     
	//Invalid Scenario		
	
	//** Update user without Authorization **//
	
	@Given("Update user with valid payload without authorization")
	public void update_user_with_valid_payload_without_authorization() throws IOException {
		requestSpec = given().spec(requestSpecification1());
	}

	@When("user send HTTPS Request and  request Body with endpoint")
	public void user_send_https_request_and_request_body_with_endpoint() throws IOException {
		 
		response = requestSpec.when().put(PropertiesFile.getProperty("baseUrl") + UserTempData.userid).then().extract().response();
		JsonPath jsonPath = new JsonPath(response.getBody().asString());
		actualcode = jsonPath.get("status").toString();
		actualmsg = jsonPath.get("error").toString();
		System.out.println(actualcode);
		System.out.println(actualmsg);
	}
		
		
		//** Update user with invalid endpoint **//
		@Given( "user with an invalid endpoint")
		public void user_with_an_invalid_endpoint() throws IOException {
			requestSpec = given().spec(requestSpecification());
		}

		@When("user send HTTPS Request and request Body with invalidendpoint")
		public void user_send_https_request_and_request_body_with_invalidendpoint() throws IOException {
			response = requestSpec
					 .when()
					 .put(PropertiesFile.getProperty("invalidendpoint")).then().log().all().extract().response();
			JsonPath jsonPath = new JsonPath(response.getBody().asString());
			actualcode = jsonPath.get("status").toString();
			actualmsg = jsonPath.get("error").toString();
			System.out.println(actualcode);
			System.out.println(actualmsg);
		}
		
		
//		// Update user with existing phonenumber
//		@Given("user update with existing phonenumber")
//		public void user_update_with_existing_phonenumber() throws IOException {
//			
//			String jsonFileName ="userdata.json";
//			String jsonKey ="updateusersamePN";		
//			requestSpec = given().spec(requestSpecification().body(JsonReader.getRequestBody(jsonFileName,jsonKey)));
//		}
//		@When("user send HTTPS Request and  request Body with existing phonenumber")
//		public void user_send_https_request_and_request_body_with_existing_phonenumber() throws IOException {
//			response = requestSpec
//					 .when()
//					 .put(PropertiesFile.getProperty("existing")).then().log().all().extract().response();
//		}


		
		
		// Update user with invalidmethods
		@Given("user with invalidmethod")
		public void user_with_invalidmethod() throws IOException {
			requestSpec = given().spec(requestSpecification());
		}
		
		@When("user send HTTPS Request and request Body with invalidmethod")
		public void user_send_https_request_and_request_body_with_invalidmethod() throws IOException {
			response = requestSpec
					 .when()
					 .get(PropertiesFile.getProperty("invalidmethod")).then().log().all().extract().response();
			JsonPath jsonPath = new JsonPath(response.getBody().asString());
			actualcode = jsonPath.get("status").toString();
			actualmsg = jsonPath.get("error").toString();
			System.out.println(actualcode);
			System.out.println(actualmsg);
		}
		
		@Then("user receives {string} with message {string}")
		public void user_receives_with_message(String code, String message) {
			JsonPath jsonPath = new JsonPath(response.getBody().asString());
			actualcode = jsonPath.get("status").toString();			
			actualmsg = jsonPath.get("message").toString();
		   assertEquals(actualcode, code);
		   assertEquals(actualmsg, message);
		   
		}
		
		
		
		//Update user with invalid payload
		@Given("user with Invalid payload")
		public void user_with_invalid_payload() throws IOException {
			String jsonFileName ="userdata.json";
			String jsonKey ="updateuserInvalid";	
			requestSpec = given().spec(requestSpecification().body(JsonReader.getRequestBody(jsonFileName,jsonKey)));
		}

		@When("user send HTTPS Request and request Body with invalid data")
		public void user_send_https_request_and_request_body_with_invalid_data() throws IOException {
			response = requestSpec
					 .when()
					 .put(PropertiesFile.getProperty("invaliddata")).then().log().all().extract().response();
			JsonPath jsonPath = new JsonPath(response.getBody().asString());
			actualcode = jsonPath.get("status").toString();
			actualmsg = jsonPath.get("message").toString();
			System.out.println(actualcode);
			System.out.println(actualmsg);
		}
		


		//Update user with missing data
		@Given("user with missing payload")
		public void user_with_missing_payload() throws IOException {
			String jsonFileName ="userdata.json";
			String jsonKey ="updateuserMissing";	
			requestSpec = given().spec(requestSpecification().body(JsonReader.getRequestBody(jsonFileName,jsonKey)));
		}

		@When("user send HTTPS Request and request Body with missing data")
		public void user_send_https_request_and_request_body_with_missing_data() throws IOException {
			response = requestSpec
					 .when()
					 .put(PropertiesFile.getProperty("invaliddata")).then().log().all().extract().response();
			JsonPath jsonPath = new JsonPath(response.getBody().asString());
			actualcode = jsonPath.get("status").toString();
			actualmsg = jsonPath.get("message").toString();
			System.out.println(actualcode);
			System.out.println(actualmsg);
			assertEquals(actualcode, "400 BAD_REQUEST");
			assertEquals(actualmsg, "User First Name is mandatory and should contains alphabets only");
		}
		
		//post invalid
		//post user without authorization
		@Given("create user with valid payload without authorization")
		public void create_user_with_valid_payload_without_authorization() throws IOException {
			requestSpec = given().spec(requestSpecification1());
		}
        
		//post with invalid endpoint
		@When("user send post Request and request Body with invalidendpoint")
		public void user_send_post_request_and_request_body_with_invalidendpoint() throws IOException {
			response = requestSpec
					 .when()
					 .post(PropertiesFile.getProperty("postinvalidendpoint")).then().log().all().extract().response();
			
		}
		@Then("user receives {string} with error message {string}")
		public void user_receives_with_error_message(String code, String error) {
			JsonPath jsonPath = new JsonPath(response.getBody().asString());
			actualcode = jsonPath.get("status").toString();
			actualmsg = jsonPath.get("error").toString();
			System.out.println(actualcode);
			System.out.println(actualmsg);
			assertEquals(actualcode, code);
			   assertEquals(actualmsg, error);
		}
		
		
		//post without mandatory fields
		
		@Given("user without mandatory fields")
		public void user_without_mandatory_fields() throws IOException {
			String jsonFileName ="userdata.json";
			String jsonKey ="createexistCN";		
			requestSpec = given().spec(requestSpecification().body(JsonReader.getRequestBody(jsonFileName,jsonKey)));
			
		}
         
		@When("user send post Request and request Body without mandatory fields")
		public void user_send_post_request_and_request_body_without_mandatory_fields() throws IOException {				
			response = requestSpec.when().post(PropertiesFile.getProperty("postinvaliddata")).then().log().all().extract().response();

		}
		@Then("user got {string} with message {string}")
		public void user_got_with_message(String code, String message) {
			JsonPath jsonPath = new JsonPath(response.getBody().asString());
	    	  actualcode = jsonPath.get("status");
	    	  actualmsg = jsonPath.get("message");
				System.out.println(actualcode);
				System.out.println(actualmsg);
				assertEquals(actualcode,code);
				assertEquals(actualmsg,message);
		}
		


        //post with invalid method
		@When("user send post Request and request Body with invalidmethod")
		public void user_send_post_request_and_request_body_with_invalidmethod() throws IOException {
			response = requestSpec
					 .when()
					 .get(PropertiesFile.getProperty("postinvalidmethod")).then().log().all().extract().response();
			JsonPath jsonPath = new JsonPath(response.getBody().asString());
			actualcode = jsonPath.get("status").toString();
			actualmsg = jsonPath.get("error").toString();
			System.out.println(actualcode);
			System.out.println(actualmsg);
		}
		
        //post with invalid request body
		@Given("user with Invalid request body")
		public void user_with_invalid_request_body() throws IOException {
			String jsonFileName ="userdata.json";
			String jsonKey ="createFNameAN";		
			requestSpec = given().spec(requestSpecification().body(JsonReader.getRequestBody(jsonFileName,jsonKey)));
		}
		@When("user send post Request and request Body with invalid data")
		public void user_send_post_request_and_request_body_with_invalid_data() throws IOException {
			response = requestSpec.when().post(PropertiesFile.getProperty("postinvaliddata")).then().extract().response();
		}	
		
		//get invalid
		//get without authorization
		@Given("get users  without authorization")
		public void get_users_without_authorization() throws IOException {
			requestSpec = given().spec(requestSpecification1());
		}

		@When("user send {string} Request  with validendpoint")
		public void user_send_request_with_validendpoint(String request) throws IOException {
			if(request.equalsIgnoreCase("get")) {
				response = requestSpec.when().get(PropertiesFile.getProperty("getvalidendpoint"));
			}else {
				response = requestSpec.when().delete();
			}
		    
		}
		
        //get by invalid userId
		@Given("get with Invalid userId")
		public void get_with_invalid_user_id() throws IOException {
			requestSpec = given().spec(requestSpecification());
		}

		@When("user send {string} Request with invaliduserId")
		public void user_send_request_with_invaliduser_id(String string) throws IOException {
			response = requestSpec.when().get(PropertiesFile.getProperty("getinvaliduserId"));
		}
		
		//get by invalid username
		@Given("get with Invalid userName")
		public void get_with_invalid_user_name() throws IOException {
			requestSpec = given().spec(requestSpecification());
		}

		@When("user send {string} Request with invaliduserName")
		public void user_send_request_with_invaliduser_name(String string) throws IOException {
			response = requestSpec.when().get(PropertiesFile.getProperty("getinvalidusername"));
		}
		
		//delete invalid
		//delete without authorization
		@Given("delete users  without authorization")
		public void delete_users_without_authorization() throws IOException {
			requestSpec = given().spec(requestSpecification1());
		}

		//delete by invalid userId
		@Given("delete with Invalid userId")
		public void delete_with_invalid_user_id() throws IOException {
			requestSpec = given().spec(requestSpecification());
			response = requestSpec.when().delete(PropertiesFile.getProperty("deleteinvaliduserId"));
		}
		
		//delete by invalid username
		@Given("delete with Invalid userName")
		public void delete_with_invalid_user_name() throws IOException {
			requestSpec = given().spec(requestSpecification());
			response = requestSpec.when().delete(PropertiesFile.getProperty("deleteinvalidusername"));
		}

}
