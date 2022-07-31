package com.zippo.weather;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class ZippoApiIn {
    @Test
    public void weatherDataForIN(){
        RestAssured.baseURI="http://api.zippopotam.us/IN/110001";
        Response response = RestAssured.get();
        //response.prettyPrint();
        JsonPath jsonResponse = response.jsonPath();
        List<Object> jsonResponseList = jsonResponse.getList("places");
        Object o = jsonResponseList.get(0);
        System.out.println("jsonresponse: " +o);
        System.out.println(" Size : " +jsonResponseList.size());

        List<Object> placesLong = jsonResponse.getList("places.longitude");
        System.out.println(placesLong.size());
        System.out.println(placesLong.get(0));

    }
}
