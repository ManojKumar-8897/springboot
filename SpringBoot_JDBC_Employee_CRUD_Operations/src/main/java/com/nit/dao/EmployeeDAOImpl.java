package com.nit.dao;

import static com.nit.constant.Constant.DELETE;
import static com.nit.constant.Constant.GET_ALL;
import static com.nit.constant.Constant.GET_ONE;
import static com.nit.constant.Constant.INSERT;
import static com.nit.constant.Constant.UPDATE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nit.model.Employee;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EmployeeRowMapper rowMapper;

	@Override
	@Transactional(rollbackForClassName = { "java.lang.Exception" })
	public void saveEmployee(Employee emp) {

		jdbcTemplate.update(INSERT, emp.getEmpId(), emp.getEmpName(), emp.getEmpAddress(), emp.getEmpSalary());

	}

	@Override
	@Transactional(rollbackForClassName = { "java.lang.Exception" })
	public void updateEmployee(Employee emp) {
		jdbcTemplate.update(UPDATE, emp.getEmpName(), emp.getEmpAddress(), emp.getEmpSalary(), emp.getEmpId());

	}

	@Override
	@Transactional(rollbackForClassName = { "java.lang.Exception" })
	public void deleteEmployee(Long id) {
		jdbcTemplate.update(DELETE, id);

	}

	@Override
	public Employee getEmployee(Long id) {

		List<Employee> emps = jdbcTemplate.query(GET_ONE, rowMapper, id);
		if (emps.isEmpty())
			return null;
		return emps.get(0);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps = jdbcTemplate.query(GET_ALL, rowMapper);
		return emps;
	}

}
