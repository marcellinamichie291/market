package com.viaje.market.dto;

import lombok.Data;

@Data
public class HotbitPeriodDto {
    private HotbitErrorDto error = null;

    private HotbitPeriodResultDto result;

    private int id;
}
