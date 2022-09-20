package com.huyhoang.currencyexchangeservice.service;

import com.huyhoang.currencyexchangeservice.entity.ExchangeValue;
import com.huyhoang.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class CurrencyExchangeService {
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Value("${server.port}")
    private int serverPort;
    public ExchangeValue getExchangeValue(String from, String to) {
        log.info("Inside getExchangeValue of CurrencyExchangeService");
        List<ExchangeValue> currencyExchanges =  currencyExchangeRepository.findByFromAndTo(from, to);
        if(currencyExchanges.size() == 0) return  null;
        ExchangeValue exchangeValue = currencyExchanges.get(0);
        exchangeValue.setPort(serverPort);
        return currencyExchanges.get(0);
    }
}
