package com.enoca.work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enoca.work.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
