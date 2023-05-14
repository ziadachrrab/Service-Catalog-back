package com.Service.Catalog.Services;

import com.Service.Catalog.Entities.Supplier;
import com.Service.Catalog.Repositories.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierService {
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier findByName(String name){
        return supplierRepository.findByName(name).orElseThrow(() -> new IllegalStateException("Supplier doesn't exist"));
    }

    public void addSupplier(Supplier supplier){
        Optional<Supplier> supplierOptional = supplierRepository.findByName(supplier.getName());
        if(supplierOptional.isPresent()){
            throw new IllegalStateException("Supplier with the name already exists");
        }
        supplierRepository.save(supplier);
    }

    @Transactional
    public void updateSupplier(String name, Supplier request){
        Supplier supplier = supplierRepository.findByName(name) .orElseThrow(() -> new IllegalStateException("Supplier with the name " +name+" doesn't exist"));
        if(request.getEmail() != null && !Objects.equals(supplier.getEmail(), request.getEmail())){
            supplier.setEmail(request.getEmail());
        }
        if(request.getPhone() != null && request.getPhone().length() ==10 &&!Objects.equals(supplier.getPhone(), request.getPhone())){
            supplier.setPhone(request.getPhone());
        }
        if(request.getName() != null && request.getName().length() > 0 && !Objects.equals(supplier.getName(), request.getName())) {
            supplier.setName(request.getName());
        }
        if(request.getCode() != null && request.getCode().length() > 0 && !Objects.equals(supplier.getCode(), request.getCode())){
            supplier.setCode(request.getCode());
        }
    }

    public void deleteSupplier(String name){
        boolean exists = supplierRepository.findByName(name).isPresent();
        if(!exists){
            throw new IllegalStateException("Supplier with the name "+name+" does not exist");
        }
        supplierRepository.deleteByName(name);
    }
}
