package com.database.hibernate;

import org.hibernate.Session;

public interface Command {

	public void executeCreateUpdateDelete(Session session) throws DataAccessException;
}
