package com.huyhoang.currencycaculationservice.controller;

import com.huyhoang.currencycaculationservice.response.ResponseObject;
import com.huyhoang.currencycaculationservice.service.CalculatedAmountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/currency-calculation")
@Slf4j
public class CalculatedAmountController {
    @Autowired
    private CalculatedAmountService calculatedAmountService;

    @GetMapping("/from/{from}/to/{to}/amount/{amount}")
    public ResponseEntity<ResponseObject> calculateAmount(@PathVariable("from") String from,
                        @PathVariable("to") String to, @PathVariable("amount") BigDecimal quantity){
        log.info("Inside getConversion of CalculatedAmountController");
        return calculatedAmountService.calculateAmount(from, to, quantity);
    }

    @GetMapping("/feign/from/{from}/to/{to}/amount/{amount}")
    public ResponseEntity<ResponseObject> calculateAmountWithFeign(@PathVariable("from") String from,
                                                        @PathVariable("to") String to, @PathVariable("amount") BigDecimal quantity){
        log.info("Inside getConversion of CalculatedAmountController");
        return calculatedAmountService.calculateAmountWithFeign(from, to, quantity);
    }


}
