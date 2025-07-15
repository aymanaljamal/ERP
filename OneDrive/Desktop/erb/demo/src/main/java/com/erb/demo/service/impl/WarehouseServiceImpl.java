package com.erb.demo.service.impl;

import com.erb.demo.model.Warehouse;
import com.erb.demo.repository.WarehouseRepository;
import com.erb.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository repository;

    @Override
    public List<Warehouse> getAll() {
        return repository.findAll();
    }

    @Override
    public Warehouse getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
