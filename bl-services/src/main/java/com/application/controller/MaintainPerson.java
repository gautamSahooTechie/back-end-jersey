package com.application.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.application.controller.exception.BLException;
import com.database.datamapper.PersonDataMapper;
import com.database.datamapper.PersonDataMapperImpl;
import com.database.hibernate.DataAccessException;
import com.model.PersonTO;

import java.sql.Blob;

@Path("/person")
public class MaintainPerson{

	@GET
	@Path("{personID}")
	@Produces("application/json")
	public Response getPersonByID(@PathParam(value = "personID") Integer personID) throws BLException {
		PersonDataMapper personDataMapper = new PersonDataMapperImpl();
		PersonTO person = new PersonTO();
		try {
			person = personDataMapper.getPerson(personID);
		} catch (DataAccessException e) {
			throw new BLException("Failed deletePersonByID service with DataAccessException + personID" + personID, e);
		}
		ResponseBuilder builder = Response.status(Response.Status.OK);
		return builder.entity(person).build();
	}
	
	@DELETE
	@Path("{personID}")
	@Consumes("application/json")
	public Response deletePersonByID(@PathParam(value = "personID") Integer personID) throws BLException {
		PersonDataMapper personDataMapper = new PersonDataMapperImpl();
		try {
			personDataMapper.deletePerson(personID);
		} catch (DataAccessException e) {
			throw new BLException("Failed deletePersonByID service with DataAccessException + personID" + personID, e);
		}
		ResponseBuilder builder = Response.status(Response.Status.OK);
		return builder.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response modifyPersonDetails(PersonTO person) throws BLException {
		PersonDataMapper personDataMapper = new PersonDataMapperImpl();
		try {
			personDataMapper.updatePerson(person);
		} catch (DataAccessException e) {
			throw new BLException("Failed modifyPersonDetails service with DataAccessException for input" + person, e);
		}
		ResponseBuilder builder = Response.status(Response.Status.OK);
		return builder.build();
	}
	
	@POST
	@Consumes("application/json")
	public Response savePersonDetails(PersonTO person) throws BLException{
		PersonDataMapper personDataMapper = new PersonDataMapperImpl();
		try {
			personDataMapper.addPerson(person);
		} catch (DataAccessException e) {
			throw new BLException("Failed savePersonDetails service with DataAccessException", e);
		};
		ResponseBuilder builder = Response.status(Response.Status.OK);
		return builder.build();
	}
}
