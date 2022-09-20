package com.huyhoang.currencycaculationservice.service;

import com.huyhoang.currencycaculationservice.VO.ExchangeValue;
import com.huyhoang.currencycaculationservice.model.CalculatedAmount;
import com.huyhoang.currencycaculationservice.proxy.CurrencyExchangeProxy;
import com.huyhoang.currencycaculationservice.response.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@Slf4j
public class CalculatedAmountService {
    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    public ResponseEntity<ResponseObject> calculateAmount(String from, String to, BigDecimal quantity) {
        log.info("Inside calculateAmount of CalculatedAmountService");
        ExchangeValue exchangeValue= restTemplate.getForObject("http://CURRENCY-EXCHANGE-SERVICE/api/v1/currency-exchange/from/" + from + "/to/" + to,
                        ExchangeValue.class);
        if(exchangeValue == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                                        new ResponseObject("Not found", "No suitable data found", "")
                                  );
        BigDecimal value = exchangeValue.getConversionMultiple().multiply(quantity);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "OK",
                        new CalculatedAmount(exchangeValue.getId(), exchangeValue.getFrom(),
                                exchangeValue.getTo(), exchangeValue.getConversionMultiple(),
                                quantity, value, exchangeValue.getPort()
                                ))
        );
    }

    public ResponseEntity<ResponseObject> calculateAmountWithFeign(String from, String to, BigDecimal quantity) {
        log.info("Inside calculateAmountWithFeign of CalculatedAmountService");
        ExchangeValue exchangeValue = currencyExchangeProxy.retrieveExchagneValue(from, to);
        if (exchangeValue == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Not found", "No suitable data found", "")
        );
        BigDecimal value = exchangeValue.getConversionMultiple().multiply(quantity);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "OK",
                        new CalculatedAmount(exchangeValue.getId(), exchangeValue.getFrom(),
                                exchangeValue.getTo(), exchangeValue.getConversionMultiple(),
                                quantity, value, exchangeValue.getPort()
                        ))
        );
    }
}
