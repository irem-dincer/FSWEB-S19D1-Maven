package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    @GetMapping
    public List<Fruit> get() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public FruitResponse get(@Positive(message = "id cannot be negative") @PathVariable("id") Long id) {
        return new FruitResponse("get by id succeed!", fruitService.getById(id));
    }

    @GetMapping("/name/{name}")  // POST → GET değişti
    public List<Fruit> getByName(@Size(min = 2, max = 45, message = "Name size must be between 2 to 45") @PathVariable("name") String name) {
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@Valid @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable Long id) {
        return fruitService.delete(id);
    }
}