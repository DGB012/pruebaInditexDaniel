package com.neoris.pruebaDaniel.infrastructure.controller;

import com.neoris.pruebaDaniel.entities.Prices;
import com.neoris.pruebaDaniel.usecases.FindAllPricesUseCase;
import com.neoris.pruebaDaniel.usecases.FindByFechaByProductIdByBrandIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PricesControllerTest {

    @Mock
    FindAllPricesUseCase findAllPricesUseCase;

    @Mock
    FindByFechaByProductIdByBrandIdUseCase findByFechaByProductIdByBrandIdUseCase;

    List<Prices> pricesList;
    Prices price;

    @InjectMocks
    PricesController pricesController;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllPrices() {
        when(findAllPricesUseCase.findAll()).thenReturn(pricesList);
        ResponseEntity<List<Prices>> result = pricesController.getAllPrices();
        assertEquals(pricesList, result.getBody());
    }

    @Test
    void findByFechaByProductIdByBrandIdUseCase() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        when(findByFechaByProductIdByBrandIdUseCase.findByFechaByProductIdByBrandId(date, 35455, 1)).thenReturn(price);
        ResponseEntity<Prices> result = pricesController.findByFechaByProductIdByBrandId("2020-06-14T10:00:00", 35455, 1);
        assertEquals(price, result.getBody());
    }
}
