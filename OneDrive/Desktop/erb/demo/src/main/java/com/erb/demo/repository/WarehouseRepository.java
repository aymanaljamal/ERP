package com.erb.demo.repository;
import com.erb.demo.model.Warehouse;
import com.erb.demo.Projection.WarehouseBasicView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Query("SELECT w.name as name, w.countryCode as countryCode, w.createdDate as createdDate FROM Warehouse w")
    List<WarehouseBasicView> findWarehouseBasicFields();
}
