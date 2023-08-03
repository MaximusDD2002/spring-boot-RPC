package com.curos.springboot;

import java.util.List;

public interface EmployeeService {

	void addEmployee(Employee e);
	void updateEmployee(long id, Employee e);
	Employee getEmployee(long id);
	List<Employee> getAll();
	void deleteEmployee(long id);
}
