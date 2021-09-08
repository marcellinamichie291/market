package com.viaje.market;

import com.viaje.market.base_dto.GlobalDto;
import com.viaje.market.dto.*;
import com.viaje.market.service.MarketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class MarketController {
    private final MarketService marketService;

    @GetMapping("/balance/{exchangeCode}")
    public GlobalDto<HotbitBalanceResultDto> balance(@Valid @PathVariable Integer exchangeCode) {
        return new GlobalDto<>(
                9000,
                HttpStatus.OK.getReasonPhrase(),
                marketService.getBalance(exchangeCode)
        );
    }

    @GetMapping("/market/today/{exchangeCode}")
    public GlobalDto<HotbitTodayResultDto> marketToday(@Valid @PathVariable Integer exchangeCode) {
        return new GlobalDto<>(
                9000,
                HttpStatus.OK.getReasonPhrase(),
                marketService.getMarketStatusToday(exchangeCode)
        );
    }

    @GetMapping("/market/period/{exchangeCode}")
    public GlobalDto<HotbitPeriodResultDto> marketPeriod(@Valid @PathVariable Integer exchangeCode, @RequestParam String period) {
        return new GlobalDto<>(
                9000,
                HttpStatus.OK.getReasonPhrase(),
                marketService.getMarketStatusByPeriode(exchangeCode, Integer.valueOf(period))
        );
    }

    @GetMapping("/book/transaction/{exchangeCode}")
    public GlobalDto<HotbitBookResultDto> transaction(@Valid @PathVariable Integer exchangeCode, @RequestParam String side, @RequestParam String offset, @RequestParam String limit) {
        return new GlobalDto<>(
                9000,
                HttpStatus.OK.getReasonPhrase(),
                marketService.getListOfTransaction(exchangeCode, side, offset, limit)
        );
    }

    @PostMapping("/book/order/{exchangeCode}")
    public GlobalDto<HotbitOrderResultDto> order(@Valid @PathVariable Integer exchangeCode, @RequestBody OrderRequestDto orderRequestDto) {
        return new GlobalDto<>(
                9000,
                HttpStatus.OK.getReasonPhrase(),
                marketService.postOrder(exchangeCode, orderRequestDto)
        );
    }

    @PostMapping("/book/cancel/{exchangeCode}")
    public GlobalDto<HotbitOrderResultDto> cancel(@Valid @PathVariable Integer exchangeCode, @RequestBody Map<String, Long> orderId) {
        return new GlobalDto<>(
                9000,
                HttpStatus.OK.getReasonPhrase(),
                marketService.cancelOrder(exchangeCode, orderId.get("orderId"))
        );
    }
}