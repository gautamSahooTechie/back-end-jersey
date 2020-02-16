package com.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;

import com.application.response.ResponseFilter;

@Provider
@ApplicationPath("bl-services")
public class CustomResourceConfig extends ResourceConfig {

	public CustomResourceConfig() {
		// Register my custom provider - not needed if it's in my.package.
		register(ResponseFilter.class);
		String[] packages = new String[] { "com.application.controller",
											"com.application" };
		packages(packages);
	}

}