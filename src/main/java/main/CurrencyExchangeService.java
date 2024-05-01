package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

	private final CurrencyConversionRateConfig currencyConversionRateConfig;

	@Autowired
	public CurrencyExchangeService(CurrencyConversionRateConfig currencyConversionRateConfig) {
		this.currencyConversionRateConfig = currencyConversionRateConfig;
	}

	public String convert(String source, String target, String amount) throws Exception {
		BigDecimal decimalAmount;
		try {
			decimalAmount = parseStringToDecimal(amount);
		} catch (Exception e) {
			throw new Exception("Amount has invalid format.");
		}
		if (currencyConversionRateConfig.getRates() == null) {
			throw new Exception("Currency exchange rates not configured");
		}
		Map<String, BigDecimal> conversionRates = currencyConversionRateConfig.getRates().get(source);

		if (conversionRates == null) {
			throw new Exception("Conversion source currency not found, no exchange rates available.");
		}
		BigDecimal rate = conversionRates.get(target);
		if (rate == null) {
			throw new Exception("Target currency for conversion does not exist.");
		}
		BigDecimal result = decimalAmount.multiply(rate);
		// DecimalFormat formatter = new DecimalFormat("#,##0.00"); // Zero padding
		DecimalFormat formatter = new DecimalFormat("#,##0.##"); // No zero padding

		return formatter.format(result.setScale(2, RoundingMode.HALF_UP));
	}

	public BigDecimal parseStringToDecimal(String amount) throws Exception {
		// All or none: if formatted, the entire string must be formatted correctly
		if (amount == null || !amount.matches("^[+-]?(\\d+|(\\d{1,3}(,\\d{3})+))(\\.\\d+)?$")) {
			throw new Exception("Invalid number format");
		}
		amount = amount.replace(",", "");
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setParseBigDecimal(true);

		BigDecimal decimal;
		try {
			decimal = new BigDecimal(decimalFormat.parse(amount).toString());
		} catch (ParseException e) {
			throw e;
		}
		return decimal.setScale(2, RoundingMode.HALF_UP);
	}

}
