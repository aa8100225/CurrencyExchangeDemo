package main;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "currencies")
public class CurrencyConversionRateConfig {
	private Map<String, Map<String, BigDecimal>> rates;

	public Map<String, Map<String, BigDecimal>> getRates() {
		return rates;
	}

	public void setRates(Map<String, Map<String, BigDecimal>> rates) {
		this.rates = rates;
	}

}
