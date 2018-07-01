package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.hibernate.validator.internal.engine.ServiceLoaderBasedConstraintMappingContributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserService {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping (path = "/users")
	public List<User> getAllUsers()	{
		
		return userDaoService.findAll();
	}
	
	@GetMapping (path = "/users/{id}")
	//public User getUser (@PathVariable Integer id) {
	public Resource<User> getUser (@PathVariable Integer id) {
		
		User user = userDaoService.getUser(id);
		
		if ( user == null)	{
			
			throw new UserNotFoundException("id: "+id);
			//return ResponseEntity.notFound().build();
		}
		
		Resource<User> r =  new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo( ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers() );
		
		r.add(linkTo.withRel("all-users"));
		
		// return ResponseEntity.ok(user);
		//return user;
		return r;
	}
	
	@PostMapping (path = "/users")
	public ResponseEntity<Object> createUser( @Valid @RequestBody User user)	{
		
		userDaoService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
				buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping (path = "/users/{id}")
	public void reomveUser (@PathVariable Integer id) {
		
		User user = userDaoService.removeUser(id);
		
		if ( user == null)	{
			
			throw new UserNotFoundException("id: "+id);
			//return ResponseEntity.notFound().build();
		}
	}
}
