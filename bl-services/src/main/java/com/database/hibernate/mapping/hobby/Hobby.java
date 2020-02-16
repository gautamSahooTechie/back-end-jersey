package com.database.hibernate.mapping.hobby;

import java.util.Objects;

public class Hobby{

	private Integer hobbyID;
	private String hobbyName;
	
	public Hobby() {}
	
	public Integer getHobbyID() {
		return hobbyID;
	}
	public void setHobbyID(Integer hobbyID) {
		this.hobbyID = hobbyID;
	}
	public String getHobbyName() {
		return hobbyName;
	}
	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}
	@Override
	public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      Hobby obj2 = (Hobby)obj;
	      if((this.hobbyID == obj2.getHobbyID()) && (this.hobbyName.equals(obj2.getHobbyName()))) {
	         return true;
	      }
	      return false;
	   }
	   
	   @Override
	public int hashCode() {
	    return Objects.hash(hobbyID,hobbyName);
	   }
	
}
