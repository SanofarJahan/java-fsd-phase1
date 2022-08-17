package com.simplilearn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.simplilearn.entity.EProductEntity;

@Repository
/*@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.*/
public class EProductDao {


	@Autowired
	//@Autowired in spring boot is used to auto-wire a bean into another bean.//
	JdbcTemplate jdbcTemplate;
	//Spring JdbcTemplate is a powerful mechanism to connect to the database and execute SQL queries.//
	
	public List<EProductEntity> getAllProducts(){
		
		return jdbcTemplate.query("select * from eproduct",new RowMapper<EProductEntity>() {
			//we can use jdbcTemplate.queryForObject() to query a single row record from database, and convert the row into an object via row mapper.//
			public EProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				EProductEntity obj= new EProductEntity();
				obj.setId(rs.getLong(1));
				obj.setName(rs.getString(2));
				obj.setPrice(rs.getBigDecimal(3));
				obj.setDateAdded(rs.getTimestamp(4));
				return obj;
			}
			
			
		});
		
		
	}
	
	
}