package stepDefination;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import resource.GlobalValueDriver;
import resource.PojoToJson;

public class WalletUpdate {
	String request;
	String response;


    @Given("^using  user (.+) update the (.+) from the metioned  (.+)$")
    public void using_user_update_the_from_the_metioned(String emailid, String walletamount, String source) throws Throwable {
    	PojoToJson req = new PojoToJson();
    	int amount = Integer.parseInt(walletamount);
    	request=req.WalletAmount(emailid, amount, source);
    }

    @When("^user call WalletUpdate API with emailID, Payment Source and Wallet amount Post http request$")
    public void user_call_walletupdate_api_with_emailid_payment_source_and_wallet_amount_post_http_request() throws Throwable {
    	GlobalValueDriver gd = new GlobalValueDriver();
		RestAssured.baseURI= gd.baseURL;
	 response = RestAssured.given().log().all().header("Content-Type", "application/json").body(request).when().
			 post("walletUpdate").then().assertThat().statusCode(200).extract().response().asString();
    }

    @Then("^User should get the 200 status code with amount added successfully (.+)$")
    public void user_should_get_the_200_status_code_with_amount_added_successfully(String message) throws Throwable {
    	assertEquals(response, message);
    }

}
