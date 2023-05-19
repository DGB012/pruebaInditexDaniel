package com.neoris.pruebaDaniel.usecases;

import com.neoris.pruebaDaniel.entities.Prices;

import java.time.LocalDateTime;

public interface FindByFechaByProductIdByBrandIdUseCase {
    Prices findByFechaByProductIdByBrandId(LocalDateTime fecha, Integer productId, Integer BrandId);
}
