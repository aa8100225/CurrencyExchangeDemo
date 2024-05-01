package main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Map<String, Object>> handleNotFoundException(NoHandlerFoundException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("msg", "error");
		response.put("error", "Route not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
