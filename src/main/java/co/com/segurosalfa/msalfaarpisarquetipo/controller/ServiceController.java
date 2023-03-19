package co.com.segurosalfa.msalfaarpisarquetipo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    
    @GetMapping("/personas")
	public ResponseEntity<?> personasFindAll() {
		return ResponseEntity.ok("todo bien");
	}
    
}
