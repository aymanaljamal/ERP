package com.erb.demo.controller;

import com.erb.demo.Projection.WarehouseBasicView;
import com.erb.demo.model.Warehouse;
import com.erb.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @GetMapping
    public List<Warehouse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Warehouse create(@RequestBody Warehouse warehouse) {
        return service.save(warehouse);
    }

    @PutMapping("/{id}")
    public Warehouse update(@PathVariable Long id, @RequestBody Warehouse updated) {
        Warehouse existing = service.getById(id);
        if (existing != null) {
            existing.setLocation(updated.getLocation());
            existing.setCapacity(updated.getCapacity());
            return service.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping("/summary")
    public List<WarehouseBasicView> getWarehouseSummary() {
        return service.getSummaryRaw();
    }
}
