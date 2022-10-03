package me.andidroid.testwar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jaxrs.RESTClient;
import org.microshed.testing.jupiter.MicroShedTest;
import org.microshed.testing.testcontainers.ApplicationContainer;
import org.testcontainers.junit.jupiter.Container;

import static io.restassured.RestAssured.given;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static io.restassured.http.ContentType.TEXT;

@Tag("MicroShedTest")
@MicroShedTest
@SharedContainerConfig(MicroshedSharedContainerConfiguration.class)
public class HelloResourceMIT
{
    
    // @Container
    // public static ApplicationContainer app = new ApplicationContainer().withReadinessPath("/testservice/hello/hello");
    // .withAppContextRoot("/testwar")
    @RESTClient
    public static HelloResource helloResource;
    
    @Test
    public void testHello()
    {
        
        Assertions.assertEquals("Hello!", helloResource.hello().readEntity(String.class));
        
        /*
         * given().when().get("/hello").then().statusCode(200).body(containsString(
         * "Hello!"));
         */
        /*
         * String response =
         * given().when().get("/hello").then().statusCode(200).contentType(TEXT).extract
         * () .as(String.class); Assertions.assertEquals("Hello!", response);
         */
    }
}
