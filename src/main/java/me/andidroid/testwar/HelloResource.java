package me.andidroid.testwar;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.ConcurrentGauge;
import org.eclipse.microprofile.metrics.annotation.Counted;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import jakarta.mvc.Controller;
import jakarta.mvc.View;
import jakarta.mvc.Models;

@Path("/hello")
public class HelloResource
{
    
    @Context
    private HttpServletRequest httpRequest;
    
    @Inject
    @ConfigProperty(name = "jboss.node.name", defaultValue = "node123")
    private String node;

    @Inject
    private Models models;
    
    /**
     *
     */
    @PostConstruct
    public void initialize()
    {
        System.out.println("HelloResource.initialize()");
    }

    @GET
    @Controller
    @Produces("text/html;charset=utf-8")
    @Path("/hello")
    @Counted(name = "hello", description = "count of hello method")
    public Response hello(@DefaultValue("jsp") @QueryParam("type") String type)
    {
        models.put("message", node);
        models.put("count", 0);
        return Response.ok("hello."+type).build();
    }
    
    @GET
    @Controller
    @Produces("text/html")
    @Path("/session")
    @Counted(name = "session", description = "count of session method")
    public Response session(@DefaultValue("jsp") @QueryParam("type") String type)
    {
        System.out.println("session on node: " + node);
        System.out.println("session id: " + httpRequest.getSession().getId());
        Integer count = (Integer) httpRequest.getSession().getAttribute("count");
        System.out.println("old value of count: " + count);
        if(count == null)
        {
            count = Integer.valueOf(1);
        }
        else
        {
            count++;
        }
        httpRequest.getSession().setAttribute("count", count);
        models.put("message", node);
        models.put("count", count);
        return Response.ok("hello."+type).build();
    }
}
