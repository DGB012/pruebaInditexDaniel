package com.neoris.pruebaDaniel.infrastructure.repository.prices.jpa;

import com.neoris.pruebaDaniel.infrastructure.domain.entity.InMemoryPricesRepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PricesJpaRepository extends JpaRepository<InMemoryPricesRepositoryEntity, Integer> {

    @Query("SELECT p FROM InMemoryPricesRepositoryEntity p WHERE p.idBrand = :brandId AND p.productId = :productId AND p.startDate <= :fecha AND p.endDate >= :fecha ORDER BY p.priority DESC LIMIT 1")
    InMemoryPricesRepositoryEntity findByFechaByProductIdByBrandId(
            @Param("fecha") LocalDateTime fecha,
            @Param("productId") Integer productId,
            @Param("brandId") Integer brandId);
}
