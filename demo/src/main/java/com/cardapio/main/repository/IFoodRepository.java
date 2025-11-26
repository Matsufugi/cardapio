package com.cardapio.main.repository;

import com.cardapio.main.modules.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IFoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAll();
}
