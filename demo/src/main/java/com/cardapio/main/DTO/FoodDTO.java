package com.cardapio.main.DTO;

import java.math.BigDecimal;

public record FoodDTO(
        String name,
        String description,
        String imageUrl,
        BigDecimal price
) {}
