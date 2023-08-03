package com.curos.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository2 extends JpaRepository<Employee, Long> {

}