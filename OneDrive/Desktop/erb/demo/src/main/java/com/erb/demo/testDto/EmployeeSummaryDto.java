package com.erb.demo.testDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeSummaryDto {
    private String name;
    private String phone;
    private String image;
}
