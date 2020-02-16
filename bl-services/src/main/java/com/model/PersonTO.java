package com.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Data
public class PersonTO implements Serializable{
	
	private static final long serialVersionUID = 7367987877857827072L;

	@JsonProperty("personID")
	private Integer personID;

	@Size(max = 150, min = 1)
	@JsonProperty("firstName")
	private String firstName;

	@Size(max = 150, min = 1)
	@JsonProperty("lastName")
	private String lastName;

	@Max(value = 120)
	@JsonProperty("age")
	private int age;

	@Size(max = 150, min = 1)
	@JsonProperty("color")
	private String color;
	
	@JsonProperty("hobbies")
	private List<String> hobbies;

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

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
}