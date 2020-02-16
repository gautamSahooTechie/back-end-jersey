package com.application.controller;

import java.util.List;

import com.database.datamapper.PersonDataMapper;
import com.database.datamapper.PersonDataMapperImpl;
import com.database.hibernate.DataAccessException;
import com.model.PersonTO;
import com.model.transformer.Mapper;

public class SummaryMapper implements Mapper{

	@Override
	public List<PersonTO> outputFromDataBase(Object...params) throws DataAccessException {
		PersonDataMapper personDataMapper = new PersonDataMapperImpl();
		return personDataMapper.getPeople();
	}

}
