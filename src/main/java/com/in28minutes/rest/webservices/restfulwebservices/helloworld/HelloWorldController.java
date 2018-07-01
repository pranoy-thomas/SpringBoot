package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	//@RequestMapping( method = RequestMethod.GET,  path = "/hello-world" )
	@GetMapping(  path = "/hello-world" )
	public String helloWorld()	{
		
		return "HelloWorld";
	}
	
	@GetMapping(  path = "/hello-world-bean" )
	public HelloWorldBean helloWorldBean()	{
		
		return new HelloWorldBean("HelloWorld");
	}
	
	@GetMapping(  path = "/hello-world/empname/{name}" )
	public HelloWorldBean helloWorldParam( @PathVariable String name )	{
		
		return new HelloWorldBean("Hello: "+ name);
	}
}
