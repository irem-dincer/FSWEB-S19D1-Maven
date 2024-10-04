package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    @GetMapping
    public List<Vegetable> get() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable get(@Positive(message = "id cannot be negative") @PathVariable("id") Long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/name/{name}")  // POST → GET değişti
    public List<Vegetable> getByName(@Size(min = 2, max = 45, message = "Name size must be between 2 to 45") @PathVariable("name") String name) {
        return vegetableService.searchByName(name);
    }

    @PostMapping
    public Vegetable save(@Valid @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @PathVariable Long id) {
        return vegetableService.delete(id);
    }
}