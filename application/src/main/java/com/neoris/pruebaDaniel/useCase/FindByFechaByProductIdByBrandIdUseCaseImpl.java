package com.neoris.pruebaDaniel.useCase;

import com.neoris.pruebaDaniel.entities.Prices;
import com.neoris.pruebaDaniel.repository.PricesRepository;
import com.neoris.pruebaDaniel.usecases.FindByFechaByProductIdByBrandIdUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FindByFechaByProductIdByBrandIdUseCaseImpl implements FindByFechaByProductIdByBrandIdUseCase {

    private PricesRepository pricesRepository;

    public FindByFechaByProductIdByBrandIdUseCaseImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public Prices findByFechaByProductIdByBrandId(LocalDateTime fecha, Integer productId, Integer BrandId) {
        return pricesRepository.findByFechaByProductIdByBrandId(fecha, productId, BrandId);
    }
}
