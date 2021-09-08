package com.viaje.market.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderRequestDto {
    @NotBlank(message = "Please provide a side")
    @Size(min = 1, max = 1, message = "Length is 1")
    private Integer side;

    @NotBlank(message = "Please provide a amount")
    private Double amount;

    @NotBlank(message = "Please provide a price")
    private Double price;

    @NotBlank(message = "Please provide a isFee")
    private Integer isfee;
}