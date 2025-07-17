package com.erb.demo.service.impl;

import com.erb.demo.dto.EmployeeSummaryDTO;
import com.erb.demo.model.Employee;
import com.erb.demo.repository.DeliveryRepository;
import com.erb.demo.repository.EmployeeRepository;
import com.erb.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeSummaryDTO> getEmployeePerformanceSummary() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(emp -> {
            int deliveredCount = deliveryRepository.countByDeliveredBy(emp);

            String status = deliveredCount > 10 ? "exceptional" : "poor";
            String warehouseName = emp.getWarehouse() != null ? emp.getWarehouse().getName() : "N/A";

            return new EmployeeSummaryDTO(
                    emp.getId(),
                    emp.getName(),
                    emp.getEmail(),
                    warehouseName,
                    deliveredCount,
                    status
            );
        }).toList();
    }

}
