package com.erb.demo.repository;

import com.erb.demo.Projection.WarehouseBasicView;
import com.erb.demo.model.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query(
            value = "SELECT " +
                    "w.name AS name, " +
                    "w.country_code AS countryCode, " +
                    "w.created_date AS createdDate, " +
                    "COUNT(e.id) AS employeeCount, " +
                    "CASE WHEN DATEDIFF(CURRENT_DATE, w.created_date) > 7 THEN 'old' ELSE 'new' END AS status " +
                    "FROM warehouse w " +
                    "LEFT JOIN employee e ON e.warehouse_id = w.id " +
                    "GROUP BY w.id, w.name, w.country_code, w.created_date",
            countQuery = "SELECT COUNT(DISTINCT w.id) FROM warehouse w",
            nativeQuery = true
    )
    Page<WarehouseBasicView> findWarehouseBasicFields(Pageable pageable);
    @Query(
            value = "SELECT " +
                    "w.name AS name, " +
                    "w.country_code AS countryCode, " +
                    "w.created_date AS createdDate, " +
                    "COUNT(e.id) AS employeeCount, " +
                    "CASE WHEN DATEDIFF(CURRENT_DATE, w.created_date) > 7 THEN 'old' ELSE 'new' END AS status " +
                    "FROM warehouse w " +
                    "LEFT JOIN employee e ON e.warehouse_id = w.id " +
                    "WHERE w.name LIKE %:name% " +
                    "GROUP BY w.id, w.name, w.country_code, w.created_date",
            countQuery = "SELECT COUNT(DISTINCT w.id) FROM warehouse w WHERE w.name LIKE %:name%",
            nativeQuery = true
    )
    Page<WarehouseBasicView> searchByName(@org.springframework.data.repository.query.Param("name") String name, Pageable pageable);

}
