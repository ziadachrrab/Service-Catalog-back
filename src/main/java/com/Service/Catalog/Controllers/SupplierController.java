package com.Service.Catalog.Controllers;

import com.Service.Catalog.Entities.Product;
import com.Service.Catalog.Entities.Supplier;
import com.Service.Catalog.Services.ProductService;
import com.Service.Catalog.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/all")
    public List<Supplier> getSuppliers3(){
        return supplierService.getAllSuppliers();
    }
    @PostMapping("/add")
    public void registerSupplier(@RequestBody Supplier supplier){
        supplierService.addSupplier(supplier);
    }
    @PutMapping("/update/{name}")
    public void updateSupplier(@PathVariable("name") String name, @RequestBody Supplier request){
        supplierService.updateSupplier(name, request);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteSupplier(@PathVariable("name") String name){
        supplierService.deleteSupplier(name);
    }
}
