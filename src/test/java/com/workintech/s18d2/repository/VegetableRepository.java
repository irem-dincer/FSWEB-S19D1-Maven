package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    // Fiyata göre azalan sırada
    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM fsweb.vegetable v ORDER BY v.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    // Fiyata göre artan sırada
    @Query(value = "SELECT v.id, v.name, v.price, v.is_grown_on_tree FROM fsweb.vegetable v ORDER BY v.price ASC", nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    // İsimde geçen sebzeleri arama
    @Query("SELECT v FROM Vegetable v WHERE v.name LIKE %:name%")
    List<Vegetable> searchByName(String name);
}