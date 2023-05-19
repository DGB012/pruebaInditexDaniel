package com.neoris.pruebaDaniel.useCase;

import com.neoris.pruebaDaniel.entities.Prices;
import com.neoris.pruebaDaniel.repository.PricesRepository;
import com.neoris.pruebaDaniel.usecases.FindAllPricesUseCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllPricesUseCaseImpl implements FindAllPricesUseCase {

    private PricesRepository pricesRepository;

    public FindAllPricesUseCaseImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public List<Prices> findAll() {
        return pricesRepository.findAll();
    }
}
