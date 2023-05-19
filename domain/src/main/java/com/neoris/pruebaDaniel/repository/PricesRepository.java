package com.neoris.pruebaDaniel.repository;

import com.neoris.pruebaDaniel.entities.Prices;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository {

    List<Prices> findAll();

    Prices findByFechaByProductIdByBrandId(LocalDateTime fecha, Integer productId, Integer BrandId);
}
