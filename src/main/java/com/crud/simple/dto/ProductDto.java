package com.crud.simple.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
public record ProductDto(
        UUID id,
        @NotBlank String name,
        @NotBlank BigDecimal price
        ) {
}
