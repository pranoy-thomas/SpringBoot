package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static Integer userCount = 3;
	
	static 	{
		
		users.add( new User (1, "Adam", new Date() ) );
		users.add( new User (2, "Eve", new Date() ) );
		users.add( new User (3, "Jacel", new Date() ) );
	}

	public List<User> findAll()	{
		
		return users;
	}
	
	public User save (User u)	{
		
		if (u.getId() == null)	{
			
			u.setId(++userCount);
		}
		
		users.add(u);
		
		return u;
	}
	
	public User getUser(Integer id)	{
		
		for ( User u : users )	{
			
			if ( u.getId().equals(id) ) {
				
				return u;
			}			
		}
		
		return null;
	}
	
	public User removeUser(Integer id)	{
		
		 Iterator<User> iterator = users.iterator();
		
		if (iterator.hasNext())	{
			 
			User u = iterator.next();
			 
			 if (u.getId().equals(id) )	{
				 iterator.remove();
				 return u;
			 }
		 }
		return null;
	}
}
