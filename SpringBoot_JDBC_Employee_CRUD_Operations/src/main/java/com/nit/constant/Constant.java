package com.nit.constant;

public class Constant {

	public static final String INSERT = "insert into employee values(?,?,?,?)";
	public static final String UPDATE = "update employee set empName=?,empAddress=?,empSalary=?where empId=?";
	public static final String DELETE = "delete from employee where empId=?";
	public static final String GET_ONE = "select * from employee where empId=?";
	public static final String GET_ALL = "select * from employee";

}
