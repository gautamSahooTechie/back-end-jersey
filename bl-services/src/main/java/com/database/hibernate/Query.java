package com.database.hibernate;

import org.hibernate.Session;

public interface Query<T> {

	public T getDataBaseOrValueObject(Session session) throws DataAccessException;
}
