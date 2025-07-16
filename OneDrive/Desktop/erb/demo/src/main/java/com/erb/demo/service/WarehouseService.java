package com.erb.demo.service;

import com.erb.demo.Projection.WarehouseBasicView;
import com.erb.demo.model.Warehouse;

import java.util.List;
import java.util.Map;

public interface WarehouseService {
    List<Warehouse> getAll();
    Warehouse getById(Long id);
    Warehouse save(Warehouse warehouse);
    void delete(Long id);
    List<WarehouseBasicView> getSummaryRaw();
}
