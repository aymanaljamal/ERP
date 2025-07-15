package com.erb.demo.testDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees/summary")
public class EmployeeSummaryController {

    @Autowired
    private EmployeeeService service;

    @GetMapping
    public Page<EmployeeSummaryDto> getPaginatedSummaries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.getEmployeeSummaries(PageRequest.of(page, size));
    }
}
