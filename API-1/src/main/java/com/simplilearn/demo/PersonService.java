package com.simplilearn.demo;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class PersonService {
	
	@Autowired
	PersonRepository repo;//connect repo to service
	
	private RestTemplate template= new RestTemplate();
	//Rest Template is used to create applications that consume RESTful Web Services.
	//basically to consume resful web services
	//add person 
	public PersonEntity addPerson(PersonEntity person) {
		return repo.save(person);
	}
	
	//get hobby of person from  API-2
	public Response getPersonWithHobby(int personId) {
		final String url="http://localhost:8082/hobby/{personId}";
		
		Map<String, Integer> map= new HashMap<String, Integer>();
		map.put("personId", personId);
		String hobby= template.getForObject(url, String.class,map);
		//The getForObject method fetches the data for the given response type from the given URI or URL template using HTTP GET method.
		//url + responseType + uriVariables as Map from Spring doc.
		//In the above code the URI variables has been passed as Map
		PersonEntity entity= repo.findById(personId).get();
		Response resp= new Response();
		resp.setEntity(entity);
		resp.setHobby(hobby);
		
		return resp;
	}

}
