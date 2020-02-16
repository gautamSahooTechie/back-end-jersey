package com.application.controller.exception;

import javax.ws.rs.core.Response;

public class BlExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<BLException> {
    @Override
    public Response toResponse(BLException exception) {
        return Response.status(Response.Status.BAD_REQUEST ).entity("Checked exception." + exception.getMessage()).type("text/plain").build();
    }
}
