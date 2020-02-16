package com.database.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QueryInvoker {

	private static QueryInvoker INSTANCE = null;
	
	public static QueryInvoker getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new QueryInvoker();
		}
		return INSTANCE;
	}
	public <T> T callDatabaseToGetObject(Query<T> query) throws DataAccessException{
		T object = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateFactory.getInstance().getHibernateSessionFromDefaultPath();
			transaction = session.beginTransaction();
			object = query.getDataBaseOrValueObject(session);
			transaction.commit();
		}catch (DataAccessException e) {
     		ExceptionHandler.throwDataAccessException("Query Couldn't be performed for the input->", query, e);
		}
		finally {
			if(session != null ) {
				try{
					session.close();
				}catch (HibernateException closeException) {
					ExceptionHandler.throwDataAccessException("Session Close Couldn't be performed for the Query->", query, closeException);
				}
			}
		}
		return object;
	}
}
