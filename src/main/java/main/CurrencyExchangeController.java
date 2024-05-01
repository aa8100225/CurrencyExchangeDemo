package main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@GetMapping(path = "/convert", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> convertCurrency(
			@RequestParam(value = "amount", required = false) String amount,
			@RequestParam(value = "source", required = false) String source,
			@RequestParam(value = "target", required = false) String target) {
		Map<String, Object> response = new HashMap<>();
		if (amount == null || source == null || target == null) {
			response.put("msg", "failed");
			response.put("error", "Missing parameters");
			return ResponseEntity.badRequest().body(response);
		}
		try {
			String covertAmount = currencyExchangeService.convert(source, target, amount);
			response.put("msg", "success");
			response.put("amount", covertAmount);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.put("msg", "failed");
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
}