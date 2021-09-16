package com.viaje.market.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MarketResponse {
    private String exhange;

    private Integer exchangeCode;

    private MarketResponseData data;

}
