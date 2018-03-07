package com.recommendation.resource;

import com.google.inject.Singleton;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.jersey.caching.CacheControl;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by naveen.kj on 07/03/18.
 */

@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Path("/hello_world")
@Singleton
public class CommonResource {

    @GET
    @Path("/show")
    @CacheControl
    public String getHelloWorld() throws JsonProcessingException {
        Map m = new HashMap<>();
        m.put("Print","Hello World");
        return new ObjectMapper().writeValueAsString(m);
    }
}
