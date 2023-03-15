package com.tek.employeebackend.controller;

import com.tek.employeebackend.model.Employees;
import com.tek.employeebackend.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    @Autowired
    private EmployeesRepository employeesRepository;

    @PostMapping("/employees")
    Employees newEmployee(@RequestBody Employees newEmployee){
        return employeesRepository.save(newEmployee);
    }

    // viewing a Employee by Id

    @GetMapping("/employees/{id}")
    Optional<Employees> getEmployeeById(@PathVariable Integer id){
        return  employeesRepository.findById(id);
    }

    // viewing all Employees
    @GetMapping("/employeeslist")
    List<Employees> getAllEmployees(){
        return  employeesRepository.findAll();
    }

     @PutMapping("/employees/{id}")
    Optional<Employees> updateEmployee(@RequestBody Employees newEmployee,@PathVariable Integer id){
         return employeesRepository.findById(id).map(employee -> {
             employee.setEmployeeName(newEmployee.getEmployeeName());
             employee.setEmployeeLastName(newEmployee.getEmployeeLastName());
             employee.setEmployeeDesignation(newEmployee.getEmployeeDesignation());
             employee.setSalary(newEmployee.getSalary());
             return employeesRepository.save(employee);
         });
         }

        @DeleteMapping("/employees/{id}")
        String deleteEmployee(@PathVariable Integer id) {
            employeesRepository.deleteById(id);
            return "Employee deleted";
        }




}
