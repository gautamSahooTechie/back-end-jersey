package com.database.datamapper.queries;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.database.hibernate.Command;
import com.database.hibernate.DataAccessException;
import com.database.hibernate.Query;
import com.database.hibernate.mapping.hobby.Hobby;
import com.database.hibernate.mapping.person.Person;
import com.model.PersonTO;

/**
 * 
 */
public class PersonQuery {

	public static class UpdatePerson implements Command {

		PersonTO personTO = null;

		public UpdatePerson(PersonTO person) {
			this.personTO = person;
		}

		@Override
		public void executeCreateUpdateDelete(Session session) throws DataAccessException {
			if (personTO != null) {
				Person person = session.get(Person.class, personTO.getPersonID());
				populateModelObject(personTO, person);
				session.update(person);
			}
		}
	}

	public static class DeletePerson implements Command {

		int personID;

		public DeletePerson(int personID) {
			this.personID = personID;
		}

		@Override
		public void executeCreateUpdateDelete(Session session) throws DataAccessException {
			Person person = session.get(Person.class, this.personID);
			session.delete(person);
		}
	}

	public static class AddPerson implements Command {
		PersonTO personTO = null;

		public AddPerson(PersonTO person) {
			this.personTO = person;
		}

		@Override
		public void executeCreateUpdateDelete(Session session) throws DataAccessException {

			if (personTO != null) {
				Person person = new Person();
				populateModelObject(personTO, person);
				session.save(person);
			}
		}
	}

	public static class GetPerson implements Query<PersonTO> {

		int personID;

		public GetPerson(int personID) {
			this.personID = personID;
		}

		@Override
		public PersonTO getDataBaseOrValueObject(Session session) throws DataAccessException {
			Criteria criteria = session.createCriteria(Person.class);
			criteria.add(Restrictions.eq("personID", personID));
			Person person = (Person) criteria.uniqueResult();
			return populateTransferObject(person);
		}
	}

	public static class QueryPeople implements Query<List<PersonTO>> {

		@Override
		@SuppressWarnings("unchecked")
		public List<PersonTO> getDataBaseOrValueObject(Session session) throws DataAccessException {
			List<PersonTO> personTOs = null;
			Criteria criteria = session.createCriteria(Person.class);
			List<Person> persons = criteria.list();
			if (persons != null && !persons.isEmpty()) {
				personTOs = new ArrayList<>();
				for (Person person : persons) {
					personTOs.add(populateTransferObject(person));
				}
			}
			return personTOs;
		}
	}

	private static void populateModelObject(PersonTO personTO, Person person) {
		person.setAge(personTO.getAge());
		person.setColor(personTO.getColor());
		person.setFirstName(personTO.getFirstName());
		person.setLastName(personTO.getLastName());
		person.setPersonID(personTO.getPersonID());
		if (personTO.getHobbies() != null) {
			
			if(person.getHobbies() != null) {
				person.getHobbies().clear();
			}
			for (String hobbyName : personTO.getHobbies()) {
				Hobby hobby = new Hobby();
				hobby.setHobbyName(hobbyName);
				person.getHobbies().add(hobby);
			}
		}
	}

	private static PersonTO populateTransferObject(Person person) {
		PersonTO personTO = new PersonTO();
		personTO.setAge(person.getAge());
		personTO.setColor(person.getColor());
		personTO.setFirstName(person.getFirstName());
		personTO.setLastName(person.getLastName());
		personTO.setPersonID(person.getPersonID());
		if (person.getHobbies() != null) {
			personTO.setHobbies(new ArrayList<>());
			for (Hobby hobby : person.getHobbies()) {
				personTO.getHobbies().add(hobby.getHobbyName());
			}
		}
		return personTO;
	}
}
