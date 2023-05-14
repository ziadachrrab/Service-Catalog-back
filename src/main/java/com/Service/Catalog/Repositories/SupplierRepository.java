package com.Service.Catalog.Repositories;

import com.Service.Catalog.Entities.Product;
import com.Service.Catalog.Entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.name = ?1")
    Optional<Supplier> findByName(String name);

    @Transactional
    @Modifying
    @Query(value = ("DELETE FROM Supplier WHERE name = ?1"))
    void deleteByName(String name);
}
