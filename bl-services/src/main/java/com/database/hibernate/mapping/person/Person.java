package com.database.hibernate.mapping.person;

import java.util.HashSet;
import java.util.Set;

import com.database.hibernate.mapping.hobby.Hobby;

public class Person {

	private Integer personID;

	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String color;
	
	private Set<Hobby> hobbies = new HashSet<Hobby>();

	//Default Constructor
	public Person() {
	}
	
	public Integer getPersonID() {
		return personID;
	}

	public void setPersonID(Integer personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<Hobby> getHobbies() {
		return hobbies;
	}
	
	public void addHobbies(Hobby hobby) {
	    this.hobbies.add(hobby);
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
}
