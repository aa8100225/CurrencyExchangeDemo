package main;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

	private final CurrencyConversionRateConfig currencyConversionRateConfig;

	@Autowired
	public CurrencyExchangeService(CurrencyConversionRateConfig currencyConversionRateConfig) {
		this.currencyConversionRateConfig = currencyConversionRateConfig;
	}

	public String convert(String source, String target, BigDecimal amount) {

		return "0.00";
	}

}
