package main;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

	public String convert(String source, String target, BigDecimal amount) {

		return "0.00";
	}

}
