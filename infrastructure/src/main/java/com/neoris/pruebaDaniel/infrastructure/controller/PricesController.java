package com.neoris.pruebaDaniel.infrastructure.controller;


import com.neoris.pruebaDaniel.entities.Prices;
import com.neoris.pruebaDaniel.usecases.FindAllPricesUseCase;
import com.neoris.pruebaDaniel.usecases.FindByFechaByProductIdByBrandIdUseCase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class PricesController {

    private FindAllPricesUseCase findAllPricesUseCase;

    private FindByFechaByProductIdByBrandIdUseCase findByFechaByProductIdByBrandIdUseCase;

    public PricesController(FindAllPricesUseCase findAllPricesUseCase, FindByFechaByProductIdByBrandIdUseCase findByFechaByProductIdByBrandIdUseCase) {
        this.findAllPricesUseCase = findAllPricesUseCase;
        this.findByFechaByProductIdByBrandIdUseCase = findByFechaByProductIdByBrandIdUseCase;
    }

    @GetMapping(value = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Prices>> getAllPrices() {
        return ResponseEntity.ok(findAllPricesUseCase.findAll());
    }

    @GetMapping(value = "/price/fecha/{fechaText}/product/{product}/brand/{brand}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Prices> findByFechaByProductIdByBrandId(@PathVariable String fechaText, @PathVariable Integer product, @PathVariable Integer brand) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.parse(fechaText, formatter);
            return ResponseEntity.ok(findByFechaByProductIdByBrandIdUseCase.findByFechaByProductIdByBrandId(fecha, product, brand));
        } catch (DateTimeException dte) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}