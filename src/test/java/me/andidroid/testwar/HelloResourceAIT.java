package me.andidroid.testwar;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Tag("ArquillianTest")
// @RunWith(Arquillian.class)
@ExtendWith(ArquillianExtension.class)
@RunAsClient
public class HelloResourceAIT
{
    @Test
    public void testHello()
    {
        given().when().get("testservice/hello/hello").then().statusCode(200).body(containsString("Hello!"));
        
    }
}
