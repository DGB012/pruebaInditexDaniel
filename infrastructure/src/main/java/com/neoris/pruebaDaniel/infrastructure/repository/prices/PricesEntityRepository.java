package com.neoris.pruebaDaniel.infrastructure.repository.prices;

import com.neoris.pruebaDaniel.entities.Prices;
import com.neoris.pruebaDaniel.infrastructure.domain.entity.InMemoryPricesRepositoryEntity;
import com.neoris.pruebaDaniel.infrastructure.mapper.inmemory.InMemoryPricesEntityMapper;
import com.neoris.pruebaDaniel.infrastructure.repository.prices.jpa.PricesJpaRepository;
import com.neoris.pruebaDaniel.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PricesEntityRepository implements PricesRepository {

    @Autowired
    private PricesJpaRepository pricesJpaRepository;

    @Override
    public List<Prices> findAll() {
        List<InMemoryPricesRepositoryEntity> result = pricesJpaRepository.findAll();
        return InMemoryPricesEntityMapper.INSTANCE.toDomainEntityList(result);
    }

    @Override
    public Prices findByFechaByProductIdByBrandId(LocalDateTime fecha, Integer productId, Integer brandId) {
        InMemoryPricesRepositoryEntity result = pricesJpaRepository.findByFechaByProductIdByBrandId(fecha, productId, brandId);
        return InMemoryPricesEntityMapper.INSTANCE.toDomainEntity(result);
    }
}
