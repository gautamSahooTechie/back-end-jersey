package com.database.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory implements HibernateHelper {

	private static HibernateFactory FACTORY = null;
	
	private static final String HIBERNATE_CONF = "com/database/hibernate/mapping/h2/hibernate.cfg.xml";
	
	public static HibernateFactory getInstance() {
		if (FACTORY == null) {
			FACTORY = new HibernateFactory();
		}
		return FACTORY;
	}

	private SessionFactory sessionFactory = null;

	@Override
	public SessionFactory getHibernateSessionFactoryFromDefaultPath() throws DataAccessException {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			try {
				cfg.configure(HIBERNATE_CONF);
			} catch (HibernateException hibernateException) {
				throw ExceptionHandler
						.throwDataAccessException("Configuration File Missing to create Hibernate Factory");
			}
			try {
				sessionFactory = cfg.buildSessionFactory();
			} catch (HibernateException hibernateException) {
				throw ExceptionHandler.throwDataAccessException(
						"Hibernate Exception Occurred While building session factory", hibernateException);
			}
		}
		return sessionFactory;
	}

	@Override
	public Session getHibernateSessionFromDefaultPath() throws DataAccessException {
		Session session = null;
		SessionFactory sessionFactory = getHibernateSessionFactoryFromDefaultPath();
		if (sessionFactory != null) {
			try {
				// Get Current Session first
				session = sessionFactory.getCurrentSession();
				if (session == null || !session.isOpen()) {
					session = sessionFactory.openSession();
				}

			} catch (HibernateException hibernateException) {
				throw ExceptionHandler.throwDataAccessException(
						"Hibernate Exception Occurred While opening new session", hibernateException);
			}
		}
		return session;
	}

}
