package com.example.CurrencyExchangeDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import main.CurrencyExchangeDemoApplication;
import main.CurrencyExchangeService;

@SpringBootTest
@ContextConfiguration(classes = CurrencyExchangeDemoApplication.class)
public class CurrencyExchangeServiceTests {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @Test
    public void testParseStringToDecimal_ValidFormats() throws Exception {
    	assertEquals(new BigDecimal("-1529").setScale(2), currencyExchangeService.parseStringToDecimal("-1,529"));
    	assertEquals(new BigDecimal("1529").setScale(2), currencyExchangeService.parseStringToDecimal("+1,529"));
        assertEquals(new BigDecimal("1234.56").setScale(2), currencyExchangeService.parseStringToDecimal("1,234.56"));
        assertEquals(new BigDecimal("1234").setScale(2), currencyExchangeService.parseStringToDecimal("1,234"));
        assertEquals(new BigDecimal("1000").setScale(2), currencyExchangeService.parseStringToDecimal("1,000"));
        assertEquals(new BigDecimal("1000000.25").setScale(2), currencyExchangeService.parseStringToDecimal("1,000,000.25"));
        assertEquals(new BigDecimal("1234.57").setScale(2), currencyExchangeService.parseStringToDecimal("1,234.567"));
    }

    @Test
    public void testParseStringToDecimal_InvalidFormats() {
        assertThrows(Exception.class, () -> currencyExchangeService.parseStringToDecimal("1,00,0.25"));
        assertThrows(Exception.class, () -> currencyExchangeService.parseStringToDecimal("12,34,567.89"));
        assertThrows(Exception.class, () -> currencyExchangeService.parseStringToDecimal("10,00000,000,234.567"));
        assertThrows(Exception.class, () -> currencyExchangeService.parseStringToDecimal("1000,100.50"));
    }
}