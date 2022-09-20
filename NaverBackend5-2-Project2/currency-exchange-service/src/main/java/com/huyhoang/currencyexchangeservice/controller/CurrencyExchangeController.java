package com.huyhoang.currencyexchangeservice.controller;

import com.huyhoang.currencyexchangeservice.entity.ExchangeValue;
import com.huyhoang.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/currency-exchange")
@Slf4j
public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to){
        log.info("Inside getConversion of CurrencyExchangeController");
        return currencyExchangeService.getExchangeValue(from, to);
    }

}
