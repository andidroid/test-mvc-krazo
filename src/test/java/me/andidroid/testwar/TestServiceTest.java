package me.andidroid.testwar;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class TestServiceTest {
    @Test
    public void testHello() {
        EntityManager em = Mockito.mock(EntityManager.class);
        Mockito.when(em.find(me.andidroid.testwar.Test.class, 1l))
                .thenReturn(new me.andidroid.testwar.Test(1l, "Test 1"));
        TestService testService = new TestService(em);
        Assertions.assertEquals(1l, testService.getById(1l).getId());
        Assertions.assertEquals("Test 1", testService.getById(1l).getText());
    }
}
