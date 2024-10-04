package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    @Query(value="SELECT f.id, f.name , f.price , f.fruit_type FROM fsweb.fruit f ORDER by f.price DESC",nativeQuery = true)
    List<Fruit>getByPriceDesc();

    @Query(value="SELECT f.id, f.name , f.price , f.fruit_type FROM fsweb.fruit f ORDER by f.price ASC",nativeQuery = true)
    List<Fruit>getByPriceAsc();


    @Query("SELECT f FROM Fruit f WHERE f.name LIKE %:name%")
    List<Fruit> searchByName(String name);
}
