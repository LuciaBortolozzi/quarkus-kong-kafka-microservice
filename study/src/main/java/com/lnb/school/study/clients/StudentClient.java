package com.lnb.school.study.clients;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.lnb.school.study.clients.dtos.StudentResponseDto;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "student-api")
public interface StudentClient {
    @GET
    @Path("/api/v1/students/sidn/{sidn}")
    StudentResponseDto getStudentBySidn(@PathParam("sidn") String sidn);
}
