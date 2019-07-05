package net.conology.jirareport;

import org.springframework.http.HttpStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CucumberStepDefinition extends SpringIntegrationTest {

	
	@When("^the client calls /version$")
	public void the_client_issues_GET_version() throws Throwable{
	    executeGet("http://localhost:5000/version");
	}
	 
	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
	    HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
	    assertThat("status code is incorrect : "+ 
	    latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
	}
	 
	@And("^the client receives server version (.+)$")
	public void the_client_receives_server_version_body(String version) throws Throwable {
	    assertThat(latestResponse.getBody(), is(version));
	}
}
