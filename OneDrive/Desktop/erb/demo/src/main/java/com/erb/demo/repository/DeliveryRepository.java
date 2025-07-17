package com.erb.demo.repository;

import com.erb.demo.model.Delivery;
import com.erb.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

        int countByDeliveredBy(Employee deliveredBy);
}
