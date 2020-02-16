package com.database.datamapper;

import java.util.List;

import com.database.datamapper.queries.PersonQuery;
import com.database.hibernate.CommandInvoker;
import com.database.hibernate.DataAccessException;
import com.database.hibernate.QueryInvoker;
import com.model.PersonTO;

public class PersonDataMapperImpl implements PersonDataMapper {

	@Override
	public void addPerson(PersonTO person) throws DataAccessException {
		CommandInvoker.executeSingleCommandWithCommit(new PersonQuery.AddPerson(person));
	}

	@Override
	public void deletePerson(int personID) throws DataAccessException {
		CommandInvoker.executeSingleCommandWithCommit(new PersonQuery.DeletePerson(personID));
	}

	@Override
	public void updatePerson(PersonTO person) throws DataAccessException {
		CommandInvoker.executeSingleCommandWithCommit(new PersonQuery.UpdatePerson(person));
	}

	@Override
	public List<PersonTO> getPeople() throws DataAccessException {
		return QueryInvoker.getInstance().callDatabaseToGetObject(new PersonQuery.QueryPeople());
	}

	@Override
	public PersonTO getPerson(int personID) throws DataAccessException {
		return QueryInvoker.getInstance().callDatabaseToGetObject(new PersonQuery.GetPerson(personID));
	}
	
}
