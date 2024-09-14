package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.nit.model.Employee;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Employee(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
	}

}
