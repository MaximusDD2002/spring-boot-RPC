package com.curos.springboot;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.Element;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository{
	
	private List<Employee> list = new ArrayList<>( List.of(new Employee(1, "Empp1", "Desc1"), new Employee(2, "Empl2", "Desc2")));
	public void save(Employee e) {
		list.add(e);
	}
	
	public List<Employee> findAll() {
		return list;
	}

	public Optional<Employee> findById(long id) {
		return list.stream().filter( x -> x.getId() == id).findFirst();
	}
	
	public void deleteById(long id) {
		list.removeIf(x -> x.getId() == id);
	}
}
