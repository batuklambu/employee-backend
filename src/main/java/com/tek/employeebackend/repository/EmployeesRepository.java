package com.tek.employeebackend.repository;

import com.tek.employeebackend.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
}
