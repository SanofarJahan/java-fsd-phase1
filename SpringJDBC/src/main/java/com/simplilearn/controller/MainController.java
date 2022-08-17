package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.simplilearn.dao.EProductDao;
import com.simplilearn.entity.EProductEntity;

@Controller
//The @Controller annotation indicates that a particular class serves the role of a controller.//
public class MainController {
	
 
	
	@Autowired
	EProductDao dao;

	
	@GetMapping("/listproduct")
	public String getAllProducts(ModelMap map) {
		
		
		List<EProductEntity> list= dao.getAllProducts();
		map.addAttribute("list", list);
		return "products";
		
	}
}
//main controller returns products//