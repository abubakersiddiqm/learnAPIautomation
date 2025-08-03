package contactlist;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ThinkingTesterContactPage {

    String serverName="https://thinking-tester-contact-list.herokuapp.com";
    String loginResourName="/users/login";
    String addContact="/contacts";
    String getUserProfile="/users/me";

    String token = null;

    @Test(priority = 0)
    public void login(){
       //using map
      /*  HashMap<String,String> loginBody=new HashMap<String,String>();
        loginBody.put("email","rafan@fake.com");
        loginBody.put("password","myPassword");*/

        // jsonOject

        JSONObject loginBody=new JSONObject();
        loginBody.put("email","rafan@fake.com");
        loginBody.put("password","myPassword");


        RestAssured.baseURI=serverName;
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(loginBody.toString())
                .post(loginResourName);

        JsonPath path =response.jsonPath();
        token = path.get("token");



        /*response.prettyPrint();*/
    }
    @Test(priority = 1)
    public void getUserProfile(){
        HashMap<String,String>auth=new HashMap<String,String>();
        auth.put("Authorization","Bearer "+token);

        RestAssured.baseURI=serverName;
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .headers(auth)
                .and().get(getUserProfile);

        response.prettyPrint();

    }
@Test(priority = 2)
    public void addContactProfile() throws JsonProcessingException {

        //pojo class to convert to json using objectmapper
        AddContact add=new AddContact();
        add.setFirstName("abu");
        add.setLastName("mo");
        add.setBirthdate("1990-01-01");
        add.setEmail("u@mail.com");
        add.setPhone("123456789");
        add.setStreet1("21  Main St.");
        add.setStreet2("Apartment");
        add.setCity("denvare");
        add.setStateProvince("KS");
        add.setPostalCode("23485");
        add.setCountry("usa");

    ObjectMapper mapper=new ObjectMapper();

    String addPojoJson = mapper.writeValueAsString(add);
    String objectWriter = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(add);
    System.out.println("pojo json \\n "+objectWriter);

    HashMap<String,String>auth=new HashMap<String,String>();
        auth.put("Authorization","Bearer "+token);

        RestAssured.baseURI=serverName;
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .headers(auth)
                .body(addPojoJson)
                .and().post(addContact);
    int statusCode = response.getStatusCode();
    System.out.println(statusCode);
    response.prettyPrint();

    }

}
