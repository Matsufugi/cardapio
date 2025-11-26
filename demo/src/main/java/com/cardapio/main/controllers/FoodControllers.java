package com.cardapio.main.controllers;

import com.cardapio.main.modules.Food;
import com.cardapio.main.services.FoodServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodControllers {

    @Autowired
    private FoodServices service;

    @GetMapping
    public ResponseEntity<List<Food>> getAll() {
        List<Food> allFoods = service.getAll();
        return ResponseEntity.ok(allFoods);
    }

    @PostMapping
    public ResponseEntity<Food> registerFood(@RequestBody @Valid Food food) {
        Food registerFood = service.register(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerFood);
    }

}
