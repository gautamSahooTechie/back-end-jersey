package com.application.controller.exception;

import javax.ws.rs.core.Response;

public class ThrowableMapper implements javax.ws.rs.ext.ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity("Something bad happened uncaught exception. Please try again !!").type("text/plain").build();
    }
}