package com.cardapio.main.controllers;

import com.cardapio.main.modules.Food;
import com.cardapio.main.services.FoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
