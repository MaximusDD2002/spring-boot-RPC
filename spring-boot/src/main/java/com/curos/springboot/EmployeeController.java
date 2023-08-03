package com.curos.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

  //private final EmployeeRepository repository;
	@Autowired
	private EmployeeService employeeService;

  /*EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }*/


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  List<Employee> getAll() {
    return employeeService.getAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/employees/create")
  void addEmployee(@RequestBody Employee addEmployee) {
    employeeService.addEmployee(addEmployee);
  }

  // Single item
  
  @GetMapping("/employees/{id}")
  Employee getEmployee(@PathVariable Long id) {
    
    return employeeService.getEmployee(id);
      //.orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  void replaceEmployee(@RequestBody Employee employee, @PathVariable Long id) {
    
    employeeService.updateEmployee(id, employee);
      /*.map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });*/
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
  }
}