package com.erb.demo.repository;

import com.erb.demo.Projection.EmployeeSummaryProjection;
import com.erb.demo.model.Delivery;
import com.erb.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
        @Query(value = """
    SELECT 
        e.id AS id,
        MAX(e.name) AS name,
        MAX(e.email) AS email,
        MAX(w.name) AS warehouseName,
        COUNT(d.id) AS totalDelivered,
        CASE 
            WHEN COUNT(d.id) > 10 THEN 'exceptional'
            ELSE 'poor'
        END AS status
    FROM delivery d
    JOIN employee e ON d.employee_id = e.id
    LEFT JOIN warehouse w ON e.warehouse_id = w.id
    GROUP BY e.id
    ORDER BY e.id
    """, nativeQuery = true)
        Page<EmployeeSummaryProjection> getEmployeeSummary(Pageable pageable);

}
