package com.simplilearn.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.beans.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	
	public Employee mapRow(ResultSet rs, int rowNum)throws SQLException{
		Employee employee =new Employee();
		employee.setEid(rs.getInt("eid"));
		employee.setName(rs.getString("name"));
		employee.setDesignation(rs.getString("designation"));
		employee.setSalary(rs.getFloat("salary"));
		return employee;
	}

	
	

}