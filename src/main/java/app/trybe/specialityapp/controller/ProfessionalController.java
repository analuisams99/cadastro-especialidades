package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**Classe ProfessionalController. */
@Path("/api/professional")
public class ProfessionalController {

  @Inject
  private ProfessionalService professionalService;
  
  /**Método de encontrar todos os profissionais listados.*/
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllProfessionals() {
    try {
      return Response.ok().entity(professionalService.findAll()).build();
    } catch (Exception e) {
      ApplicationError error = new ApplicationError(
          Response.Status.NOT_FOUND, "Nenhum registro foi encontrado!");
      return Response.status(error.getStatus()).entity(error).build();
    }
  }
  
  /**Método de achar um profissional pelo id.*/
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findById(@PathParam("id") Integer id) {
    try {
      Professional professional = professionalService.findById(id);
      if (professional != null) {
        return Response.ok(professional).build();
      } else {
        ApplicationError error = new ApplicationError(
            Response.Status.NOT_FOUND,
            "Não foi possível encontrar o profissional com o ID informado.");
        return Response.status(error.getStatus()).entity(error).build();
      }
    } catch (Exception e) {    
      ApplicationError error = new ApplicationError(
             Response.Status.INTERNAL_SERVER_ERROR, "Ocorreu um erro interno no servidor.");
      return Response.status(error.getStatus()).entity(error).build();
    }
  }
  
  /**Método de inserir um novo profissional.*/
  @POST
  @Path("/add")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addProfessional(Professional professional) {
    try {
      professionalService.save(professional);
      return Response.status(Response.Status.CREATED).entity("Inserido").build();
    } catch (Exception e) {
      ApplicationError error = new ApplicationError(
          Response.Status.BAD_REQUEST, 
          "Não é permitido inserir novos registros com ID explícito");
      return Response.status(error.getStatus()).entity(error).build();
    }
  }
  
  /**Método de atualizar o nome e a especialidade de um profissional.*/
  @PUT
  @Path("/edit/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response editProfessional(@PathParam("id") Integer id, Professional professional) {
    try {
      professionalService.update(id, professional);
      return Response.ok().entity(String.format("ID [%d] atualizado", id)).build();
    } catch (Exception e) {
      ApplicationError error = new ApplicationError(
          Response.Status.NOT_FOUND, 
          "Não é possível editar, o ID informado não existe");
      return Response.status(error.getStatus()).entity(error).build();
    }
  }
  
  /**Método de deletar um profissional pelo id..*/
  @DELETE
  @Path("/delete/{id}")
  public Response deleteProfessional(@PathParam("id") Integer id) {
    try {
      professionalService.delete(id);
      return Response.ok().entity(String.format("ID [%d] removido", id)).build();
    } catch (Exception e) {
      ApplicationError error = new ApplicationError(
          Response.Status.NOT_FOUND, 
          "Não é possível deletar, o ID informado não existe");
      return Response.status(error.getStatus()).entity(error).build();
    }
  }
}