package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="some dummy description")
public class User {

	private Integer id;
	
	@Size(min=2, message= "size shd be grater than 2")
	private String name;
	
	@Past
	@ApiModelProperty(notes="bdy cant be past")
	private Date bithDate;
	
	public User() {
		
	}
	
	public User(Integer id, String name, Date bithDate) {
		super();
		this.id = id;
		this.name = name;
		this.bithDate = bithDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", bithDate=" + bithDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBithDate() {
		return bithDate;
	}

	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}
	
	
}
