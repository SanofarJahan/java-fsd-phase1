package com.simplilearn.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
//RestController is used for making restful web services with the help of the @RestController annotation. This annotation is used at the class level and allows the class to handle the requests made by the client//
@RequestMapping("/api/user")
//@RequestMapping Annotation which is used to map HTTP requests to handler methods of MVC and REST controllers. In Spring MVC applications, the DispatcherServlet (Front Controller) is responsible for routing incoming HTTP requests to handler methods of controllers.//
//all req cmig from /api/user is read by this controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	///create new record
	@PostMapping("/")
	//@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression//
	public ResponseEntity<User> addUser(@RequestBody User u){
		//request body is user of u.The @RequestBody annotation is applicable to handler methods of Spring controllers. This annotation indicates that Spring should deserialize a request body into an object. This object is passed as a handler method parameter
		//By using @RequestBody annotation you will get your values mapped with the model you created in your system for handling any specific call//
		
		
		User user= service.addUser(u);
		if(user!=null)  
			return new ResponseEntity<User>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//List of Users Or RETRIVE DATA
	@GetMapping("/")
	//@GetMapping annotated methods in the @Controller annotated classes handle the HTTP GET requests matched with given URI expression.//
	public  List<User> getAllUser(){
		return service.getAllUser();
	}
	
	//get user by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		  User user= service.getUserById(id);
		  
		  if(user!=null)
			  return new ResponseEntity<User>(user,HttpStatus.FOUND);
		  else
			  return new  ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
	}
	
	//update user by id
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable int id){
		//The @PathVariable annotation is used to extract the value from the URI//
		User data= service.updateUser(user, id);
		
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("User is Not Available",HttpStatus.NOT_FOUND);
	}
	///DELETE USER BY ID
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable  int id ){
		
		if(service.deleteUser(id))
			return new ResponseEntity<Object>("User Deleted", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No User Found",HttpStatus.NOT_FOUND);
	}
	 

}