package com.erb.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private double salary;

    @Column(name = "work_hours")
    private int workHours;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "warehouse_id") 
    private Warehouse warehouse;

    private String image;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference(value = "employee-stock")
    private List<StockReceipt> stockReceipts;

    public enum Rank {
        STAFF,
        MANAGER
    }
}
