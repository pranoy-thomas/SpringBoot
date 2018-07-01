package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

	String msg;
	
	public HelloWorldBean(String string) {
		msg = string;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [msg=" + msg + "]";
	}

	
}
