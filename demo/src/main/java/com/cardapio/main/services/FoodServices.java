package com.cardapio.main.services;

import com.cardapio.main.modules.Food;
import com.cardapio.main.repository.IFoodRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServices {

    @Autowired
    private IFoodRepository repository;

    public List<Food> getAll() {
        return repository.findAll();
    }

    public Food register(@Valid Food food) {
        return repository.save(food);

    }
}
