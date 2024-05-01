package main;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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

		return "0.00";
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
		return decimal;
	}

}
