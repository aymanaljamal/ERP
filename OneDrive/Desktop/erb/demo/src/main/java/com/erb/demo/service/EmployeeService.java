package com.erb.demo.service;

import com.erb.demo.dto.EmployeeSummaryDTO;
import com.erb.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(Long id);
    Employee save(Employee employee);
    void delete(Long id);
    List<EmployeeSummaryDTO> getEmployeePerformanceSummary();

}
