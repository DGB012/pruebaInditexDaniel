package com.neoris.pruebaDaniel.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Prices {

    @JsonIgnore
    private Integer idPrice;

    private Integer idBrand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer productId;

    @JsonIgnore
    private Integer priority;

    private double price;

    @JsonIgnore
    private String curr;
}
