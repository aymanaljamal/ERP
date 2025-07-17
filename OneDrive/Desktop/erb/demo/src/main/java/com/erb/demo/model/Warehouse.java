package com.erb.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "warehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private int capacity;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "warehouse")
    @JsonManagedReference(value = "warehouse-stock")
    private List<StockReceipt> stockReceipts;

    @OneToMany(mappedBy = "warehouse")
    private List<Employee> employees;
}
