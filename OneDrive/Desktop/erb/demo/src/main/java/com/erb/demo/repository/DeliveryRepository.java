package com.erb.demo.repository;

import com.erb.demo.Projection.EmployeeSummaryProjection;
import com.erb.demo.model.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

        @Query(value = """
        SELECT
            e.id AS id,
            e.name AS name,
            e.email AS email,
            w.name AS warehouseName,
            COUNT(d.id) AS totalDelivered,
            CASE
                WHEN COUNT(d.id) > 10 THEN 'exceptional'
                ELSE 'poor'
            END AS status
        FROM employee e
        LEFT JOIN warehouse w ON e.warehouse_id = w.id
        LEFT JOIN delivery d ON d.employee_id = e.id
        GROUP BY e.id, e.name, e.email, w.name
        """,
                countQuery = """
        SELECT COUNT(*) FROM employee
        """,
                nativeQuery = true)
        Page<EmployeeSummaryProjection> getEmployeeSummary(Pageable pageable);
}
