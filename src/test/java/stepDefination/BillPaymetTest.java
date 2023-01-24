package stepDefination;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import resource.GlobalValueDriver;
import resource.PojoToJson;

public class BillPaymetTest {
	String Billrequest;
	String request;
	String BillValue;
	String response;
	
	

	 @Given("^enter user (.+)$")
	    public void enter_user(String emailid) throws Throwable {
		 PojoToJson req = new PojoToJson();
		 Billrequest = req.serial(emailid);
	    }


	    @When("^user call billDetails API with emailID GET http request$")
	    public void user_call_billdetails_api_with_emailid_get_http_request() throws Throwable {
	    	GlobalValueDriver gd = new GlobalValueDriver();
	    	RestAssured.baseURI= gd.baseURL;
	    	String BillValue =RestAssured.given().log().all()
	    			.when().get("GetBill")
	    			.then().assertThat().log().all().statusCode(200).extract().response().asString();
	    }

	   

	    @Then("^response comes with unpaid bill$")
	    public void response_comes_with_unpaid_bill() throws Throwable {
	        // Write code here that turns the phrase above into concrete actions
	    	assertNotNull(BillValue);
	    }
	    

	    @Given("^user bill details (.+) and (.+)$")
	    public void user_bill_details_and(String billid, String emailid) throws Throwable {
	    	PojoToJson req = new PojoToJson();
	    	request = req.BillPaymentserial(emailid, billid);
	    	
	    }
	    

	    @When("^user call payBill API with Bill ID Post http request, with response code (.+)$")
	    public void user_call_paybill_api_with_bill_id_post_http_request_with_response_code(String code) throws Throwable {
	    	int statuscode = Integer.parseInt(code);
	    	response = RestAssured.given().log().all().header("Content-Type", "application/json").body(request).when().
	   			 post("payBill").then().assertThat().statusCode(statuscode).extract().response().asString();
	    }

	    @Then("^status code \"([^\"]*)\" is  and response should be \"([^\"]*)\"$")
	    public void status_code_is_and_response_should_be(String code, String message) throws Throwable {
	        // Write code here that turns the phrase above into concrete actions
	    	assertEquals(response, message);
	    }


}
