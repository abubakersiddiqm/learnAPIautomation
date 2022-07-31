package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class ZippoApiForIndia {

    public Response response;
    public JsonPath jsonPath;
    @Given("request uri for zippo")
    public void request_uri_for_zippo() {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI="http://api.zippopotam.us/IN/110001";
        //throw new cucumber.api.PendingException();
    }

    @And("get the value for india")
    public void get_the_value_for_india() {
        // Write code here that turns the phrase above into concrete actions
        response = RestAssured.get();
         //response.prettyPrint();
         jsonPath = response.jsonPath();
        //throw new cucumber.api.PendingException();
    }

    @When("places is Janpath")
    public void places_is_Janpath() {
        List<Object>allPlaces =jsonPath.getList("places");
        int size = allPlaces.size();
        System.out.println( "  Places :" +size);
        System.out.println(allPlaces.get(0));
        for (Object s:allPlaces) {
            System.out.println(allPlaces);
        }
    }
    @Then("validate the status code")
    public void validateTheStatusCode() {
        int statusCode =response.getStatusCode();
        System.out.println(statusCode);
    }
}
