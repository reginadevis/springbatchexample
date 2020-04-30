package com.scheduled.pojo;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="detail")
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType(propOrder = {"ID", "name" , "salary"})
public class PojoXML {
	
	public int ID;

	public String name;

	public double salary;
	
	
	public PojoXML() {
		super();
	}

	public PojoXML(int iD, String name, double salary) {
		super();
		ID = iD;
		this.name = name;
		this.salary = salary;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override public String toString() {
	    return String.format("ID : %d Name : %s Salary : %f" , ID, name, salary );
	 }

}
