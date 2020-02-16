package com.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.application.controller.exception.BLException;
import com.database.hibernate.DataAccessException;
import com.model.PersonTO;

@Path("/people/summary")
public class SummaryController {

	@GET
	@Produces("application/json")
	public Response summary() throws BLException{
		
		List<PersonTO> persons = new ArrayList<PersonTO>();
		SummaryMapper mapper = new SummaryMapper();
		try {
			persons = mapper.outputFromDataBase();
		} catch (DataAccessException e) {
			throw new BLException("Failed summary service with DataAccessException", e);
		}
		
		ResponseBuilder builder = Response.status(Response.Status.OK);
		return builder.entity(persons).build();
	}
}
