package com.erb.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_receipt")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private LocalDateTime receivedAt;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference(value = "employee-stock")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference(value = "product-stock")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @JsonBackReference(value = "warehouse-stock")
    private Warehouse warehouse;
}
