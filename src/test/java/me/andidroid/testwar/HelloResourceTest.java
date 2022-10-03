package me.andidroid.testwar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HelloResourceTest {
    @Test
    public void testHello() {
        HelloResource helloResource = new HelloResource();
        Assertions.assertEquals("Hello!", helloResource.hello().getEntity().toString());
    }
}
