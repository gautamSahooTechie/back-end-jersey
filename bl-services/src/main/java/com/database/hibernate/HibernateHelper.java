package com.database.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface HibernateHelper {

	SessionFactory getHibernateSessionFactoryFromDefaultPath() throws DataAccessException;
	Session getHibernateSessionFromDefaultPath() throws DataAccessException;
}
