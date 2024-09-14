package com.nit;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.dao.EmployeeDAOImpl;
import com.nit.model.Employee;

@SpringBootTest
class SpringBootJdbcEmployeeCrudOperationsApplicationTests {

	@Autowired
	private EmployeeDAOImpl dao;

	@Test
	void saveEmployee() {
		Employee emp = new Employee(300L, "Sheshi", "Hyd", 50000d);
		dao.saveEmployee(emp);

	}

	@Test
	void updateEmployee() {
		Employee emp = dao.getEmployee(1l);
		emp.setEmpAddress("Mncl");
		dao.updateEmployee(emp);
		Employee emp1 = dao.getEmployee(1l);
		Assertions.assertEquals("Mncl", emp1.getEmpAddress());
	}

	@Test
	void deleteEmployee() {
		dao.deleteEmployee(15l);
		Employee emp = dao.getEmployee(15l);
		Assertions.assertNull(emp);
	}

	@Test
	void getEmployee() {
		Employee emp = dao.getEmployee(125l);
		Assertions.assertNotNull(emp);
		Assertions.assertTrue(emp != null);
	}

	@Test
	void getAllEmployee() {

		List<Employee> emps = dao.getAllEmployees();
		Assertions.assertNotNull(emps);
		Assertions.assertTrue(!emps.isEmpty());
	}

}
