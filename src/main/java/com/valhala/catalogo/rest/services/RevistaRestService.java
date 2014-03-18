package com.valhala.catalogo.rest.services;

import java.util.List;

import javax.ejb.EJB;
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

import com.valhala.catalogo.modelo.Revista;
import com.valhala.catalogo.rest.tipos.Erro;
import com.valhala.catalogo.rest.tipos.RetornoRest;
import com.valhala.catalogo.service.beans.RevistaService;
import com.valhala.catalogo.service.exceptions.CatalogoServiceException;

/**
 * Serviço REST para as operações CRUD da aplicação.
 * @author F0113090
 * 
 */
@Path("/revistas")
public class RevistaRestService {
	
	@EJB
    private RevistaService revistaService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarTodasRevistas() {
    	Response.ResponseBuilder builder = null;
    	List<Revista> revistas;
    	try {
			revistas = this.revistaService.buscarRevistas();
			builder = Response.ok(revistas);
		} catch (CatalogoServiceException e) {
			Erro erro = new Erro(e.getCause().getClass().getCanonicalName(), e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(erro);
		} // fim do bloco try/catch
        return builder.build();
    } // fim do método buscarTodasRevistas

    @POST
    @Path("/gravar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gravarRevista(Revista revista) {
    	Response.ResponseBuilder builder = null;
    	RetornoRest retorno;
    	try {
			this.revistaService.salvarRevista(revista);
			retorno = new RetornoRest("Revista inserida com sucesso!", revista);
			builder = Response.ok(retorno);
		} catch (CatalogoServiceException e) {
			Erro erro = new Erro(e.getClass().getCanonicalName(), e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(erro);
		} // fim do bloco try/catch
        return builder.build();
    } // fim do método gravarRevista

    @PUT
    @Path("/editar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editarRevista(@PathParam("id") Long id, Revista revista) {
    	Response.ResponseBuilder builder = null;
    	RetornoRest retorno;
        try {
			this.revistaService.editarRevista(revista);
			retorno = new RetornoRest("Revista atualizada com sucesso!", revista);
			builder = Response.ok(retorno);
		} catch (CatalogoServiceException e) {
			Erro erro = new Erro(e.getCause().getClass().getCanonicalName(), e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(erro);
		} // fim do bloco try/catch
        return builder.build();
    } // fim do método editarRevista

    @DELETE
    @Path("/deletar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarRevista(@PathParam("id") Long id) {
    	Response.ResponseBuilder builder = null;
    	RetornoRest retorno;
    	try {
			this.revistaService.deletarRevista(id);
			retorno = new RetornoRest("Revista removida com sucesso!", null);
			builder = Response.ok(retorno);
		} catch (CatalogoServiceException e) {
			Erro erro = new Erro(e.getCause().getClass().getCanonicalName(), e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(erro);
		} // fim do bloco try/catch
    	return builder.build();
    } // fim do método deletarRevista

} // fim da classe RevistaRestService