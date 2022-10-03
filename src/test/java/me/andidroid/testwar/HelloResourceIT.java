package me.andidroid.testwar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import static io.restassured.RestAssured.given;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static io.restassured.http.ContentType.TEXT;

@Tag("IntegrationTest")
public class HelloResourceIT
{
    
    // @Test
    public void testHello()
    {
        
        given().when().get("testservice/hello/hello").then().statusCode(200).body(containsString("Hello!"));
        
        /*
         * String response =
         * given().when().get("/hello").then().statusCode(200).contentType(TEXT).extract
         * () .as(String.class); Assertions.assertEquals("Hello!", response);
         */
    }
}
