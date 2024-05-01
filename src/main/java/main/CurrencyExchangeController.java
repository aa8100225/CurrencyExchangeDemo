package main;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency")
public class CurrencyExchangeController {

	private final CurrencyExchangeService currencyExchangeService;

	@Autowired
	public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
		this.currencyExchangeService = currencyExchangeService;
	}

	@GetMapping("/convert")
	public String convertCurrency(@RequestParam("amount") BigDecimal amount, @RequestParam("source") String source,
			@RequestParam("target") String target) {
		return currencyExchangeService.convert(source, target, amount);
	}
}