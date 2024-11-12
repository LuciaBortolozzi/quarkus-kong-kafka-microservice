package com.lnb.school.study.clients;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.lnb.school.study.clients.dtos.ProfessorResponseDto;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "professor-api")
public interface ProfessorClient {
    @GET
    @Path("/api/v1/professors/pidn/{pidn}")
    ProfessorResponseDto getProfessorByPidn(@PathParam("pidn") String pidn);
}
