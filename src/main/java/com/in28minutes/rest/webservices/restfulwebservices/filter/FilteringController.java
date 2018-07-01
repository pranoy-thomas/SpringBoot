package com.in28minutes.rest.webservices.restfulwebservices.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping(path="/filtering")
	public SomeBean getBean()	{
		
		return new SomeBean("val1","val2","val3");
	}

}
