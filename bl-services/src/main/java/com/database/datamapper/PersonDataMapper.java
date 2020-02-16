package com.database.datamapper;

import java.util.List;

import com.database.hibernate.DataAccessException;
import com.model.PersonTO;

public interface PersonDataMapper {

	public void addPerson(PersonTO person) throws DataAccessException ;
	
    public void deletePerson(int personID) throws DataAccessException ;
    
    public void updatePerson(PersonTO person) throws DataAccessException ;
    
    public PersonTO getPerson(int personID) throws DataAccessException ;
    
    public List<PersonTO> getPeople() throws DataAccessException;
}
