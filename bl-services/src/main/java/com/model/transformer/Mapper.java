package com.model.transformer;

import com.database.hibernate.DataAccessException;

public interface Mapper {

	public <O> O outputFromDataBase(Object...objects) throws DataAccessException;
}
