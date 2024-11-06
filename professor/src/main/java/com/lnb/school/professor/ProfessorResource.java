package com.lnb.school.professor;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import com.lnb.school.professor.dtos.ProfessorRequestDto;
import com.lnb.school.professor.dtos.oas.ProfessorOAS;
import com.lnb.school.professor.services.ProfessorService;

import jakarta.inject.Inject;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/professors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorResource {
    ProfessorService professorService;

    @Inject
    public ProfessorResource(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @POST
    @Operation(summary = "Add a new Professor", description = "This API will add a new Professor to database")
    @RequestBody(content = {
            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.Request.class))})
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Accepted", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.Response.class))),
            @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.BadRequest.class)))
    })
    public Response addProfessor(ProfessorRequestDto request) throws ValidationException {
        return Response.accepted().entity(professorService.saveProfessor(request)).build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Update Professor", description = "This API will update Professor to database")
    @RequestBody(content = {
            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.Request.class))})
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.Response.class))),
            @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.BadRequest.class)))
    })
    public Response updateProfessor(ProfessorRequestDto request, @PathParam("id") Long id) throws ValidationException {
        return Response.ok().entity(professorService.updateProfessor(request, id)).build();
    }

    @GET
    @Operation(summary = "Get List Professor", description = "This API will get List Professor from Database")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.Response.class))),
            @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.BadRequest.class)))
    })
    public Response getListProfessor() {
        return Response.ok().entity(professorService.getListProfessor()).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Get Professor by ID", description = "This API will get Professor by ID from Database")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.Response.class))),
            @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.BadRequest.class)))
    })
    public Response getProfessorByID(@PathParam("id") Long id) {
        return Response.ok().entity(professorService.getProfessorByID(id)).build();
    }

    @GET
    @Path("/lidn/{lidn}")
    @Operation(summary = "Get Professor by LIDN", description = "This API will get Professor by LIDN from Database")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.Response.class))),
            @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.BadRequest.class)))
    })
    public Response getProfessorByLidn(@PathParam("lidn") String lidn) {
        return Response.ok().entity(professorService.getProfessorByLidn(lidn)).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete Professor", description = "This API will delete Professor by ID")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.Response.class))),
            @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProfessorOAS.BadRequest.class)))
    })
    public Response deleteProfessor(@PathParam("id") Long id) throws ValidationException {
        return Response.ok().entity(professorService.deleteProfessor(id)).build();
    }
}