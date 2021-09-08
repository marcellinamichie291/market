package com.viaje.market.base_dto;

import com.viaje.market.dto.HotbitErrorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseDto {
    protected HotbitErrorDto error;
}
