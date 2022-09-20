package com.huyhoang.currencycaculationservice.proxy;

import com.huyhoang.currencycaculationservice.VO.ExchangeValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
    @GetMapping("api/v1/currency-exchange/from/{from}/to/{to}")
    ExchangeValue retrieveExchagneValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
