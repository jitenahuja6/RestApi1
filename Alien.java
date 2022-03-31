// Here we are declaring the resource field and its getter and setters, to string and default constructor.

package com.telusko.demorest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

//This we are declaring as we need to declare this in rest as this is root element for AlienResource.
@XmlRootElement
public class Alien implements Serializable
{
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = -4215105985743117859L;
	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String name;
	private int points;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", points=" + points + ", id=" + id + "]";
	}
	Checking git merge
	done
	
	
}
