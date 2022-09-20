package com.huyhoang.currencyexchangeservice.repository;

import com.huyhoang.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
    List<ExchangeValue> findByFromAndTo(String from, String to);
}
