package com.erb.demo.testDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeeServiceImpl implements EmployeeeService {

    @Autowired
    private EmployeeeRepository repository;

    @Override
    public Page<EmployeeSummaryDto> getEmployeeSummaries(Pageable pageable) {
        return repository.findAllSummary(pageable);
    }
}
