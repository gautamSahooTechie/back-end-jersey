package com.database.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommandInvoker {

	public static final void executeSingleCommandWithCommit(Command command) throws DataAccessException{
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateFactory.getInstance().getHibernateSessionFromDefaultPath();
			transaction = session.beginTransaction();
			command.executeCreateUpdateDelete(session);
			transaction.commit();
		}catch (DataAccessException e) {
			if(transaction != null) {
				try{
					transaction.rollback();
				}catch (Exception rollbackException) {
					ExceptionHandler.throwDataAccessException("Rollback Couldn't be performed for the Command->", command, rollbackException);
				}
			}
		}
		finally {
			if(session != null ) {
				try{
					session.close();
				}catch (HibernateException closeException) {
					ExceptionHandler.throwDataAccessException("Session close Couldn't be performed for the Command->", command, closeException);
				}
			}
		}
	}
}