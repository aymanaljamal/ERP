package com.erb.demo.service.impl;

import com.erb.demo.Projection.WarehouseBasicView;
import com.erb.demo.model.Warehouse;
import com.erb.demo.repository.WarehouseRepository;
import com.erb.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository repository;

    @Override
    public Page<WarehouseBasicView> getSummaryRaw(Pageable pageable) {
        return repository.findWarehouseBasicFields(pageable);
    }
    @Override
    public List<Warehouse> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<WarehouseBasicView> searchByName(String name, Pageable pageable) {
        return repository.searchByName(name, pageable);
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
