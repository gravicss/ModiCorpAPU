package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resource.GlobalValueDriver;
import resource.PojoToJson;

public class StepDefination {
	String request;
	String response;
	
	

	@Given("^create user using(.+)$")
    public void create_user_using(String emailid)  throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PojoToJson req = new PojoToJson();
		 request = req.serial(emailid);
	}
	
	@When("^user call addUser API with (.+) Post http request$")
	public void user_call_addUser_API_with_Post_http_request(String arg1) throws Throwable {
		GlobalValueDriver gd = new GlobalValueDriver();
		RestAssured.baseURI= gd.baseURL;
	 response = RestAssured.given().log().all().header("Content-Type", "application/json").body(request).when().
			 post("addUser").then().assertThat().statusCode(200).extract().response().asString();
	}

	 @Then("^status code is (.+) and response should be (.+)$")
	    public void status_code_is_and_response_should_be(String errorcode, String message) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals(response, message);
	   
	}





}
