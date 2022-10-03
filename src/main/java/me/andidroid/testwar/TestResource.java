package me.andidroid.testwar;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.opentracing.Traced;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
@Traced
public class TestResource {

    @Inject
    private TestService testService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam(value = "id") String id) {
        return Response.ok(testService.getById(Long.parseLong(id))).build();
    }
}
