package com.erb.demo.testDto;

import com.erb.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.erb.demo.dto.EmployeeSummaryDto(e.name, e.phone, e.image) FROM Employee e")
    Page<EmployeeSummaryDto> findAllSummary(Pageable pageable);
}