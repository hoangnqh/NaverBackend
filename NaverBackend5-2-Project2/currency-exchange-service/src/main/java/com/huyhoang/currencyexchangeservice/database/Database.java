package com.huyhoang.currencyexchangeservice.database;

import com.huyhoang.currencyexchangeservice.entity.ExchangeValue;
import com.huyhoang.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class Database {
    private static  final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(CurrencyExchangeRepository currencyExchangeRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                ExchangeValue currencyExchange1 =
                        new ExchangeValue(10001L,  "USD", "VND", new BigDecimal(23300),0);
                logger.info("Insert data: " + currencyExchangeRepository.save(currencyExchange1));
                ExchangeValue currencyExchange2 =
                        new ExchangeValue(10002L,  "EUR", "VND", new BigDecimal(23800),0);
                logger.info("Insert data: " + currencyExchangeRepository.save(currencyExchange2));

            }
        };
    }
}
