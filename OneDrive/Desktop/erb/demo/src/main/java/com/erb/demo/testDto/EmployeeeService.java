package com.erb.demo.testDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeeService {
    Page<EmployeeSummaryDto> getEmployeeSummaries(Pageable pageable);
}
