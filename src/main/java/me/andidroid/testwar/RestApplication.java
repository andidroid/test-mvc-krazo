package me.andidroid.testwar;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;
@ApplicationPath("/testmvckrazoservice")
public class RestApplication extends Application
{
    @Override
    public Set<Class<?>> getClasses() {
        return Collections.singleton(HelloResource.class);
    }
}
