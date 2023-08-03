package com.curos.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import 

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void addEmployee(Employee e) {
		repository.save(e);
		log.info("addEmployee called");
	}

	@Override
	public void updateEmployee(long id, Employee e) {

		Optional<Employee> found = repository.findById(id);
		if (found.isPresent()) {
			found.get().setName(e.getName());
			found.get().setRole(e.getRole());
			repository.save(found.get());
			return;
		}
		new EmployeeNotFoundException(id);
	}

	@Override
	public Employee getEmployee(long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteEmployee(long id) {
		repository.deleteById(id);
	}

}
