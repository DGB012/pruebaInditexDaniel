package com.neoris.pruebaDaniel.infrastructure.mapper.inmemory;

import com.neoris.pruebaDaniel.entities.Prices;
import com.neoris.pruebaDaniel.infrastructure.domain.entity.InMemoryPricesRepositoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InMemoryPricesEntityMapper extends InMemoryEntityMapper<Prices, InMemoryPricesRepositoryEntity> {
    InMemoryPricesEntityMapper INSTANCE = Mappers.getMapper(InMemoryPricesEntityMapper.class);

    @Override
    @Mapping(source = "idPrice", target = "idPrice")
    Prices toDomainEntity(InMemoryPricesRepositoryEntity inMemoryPricesRepositoryEntity);
}
