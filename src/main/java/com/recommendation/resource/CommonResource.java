package com.recommendation.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

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
public class CommonResource {

    @GET
    @Path("/show")
    @CacheControl
    public String getHelloWorld() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new HashMap<>().put("Print","Hello World"));
    }
}
