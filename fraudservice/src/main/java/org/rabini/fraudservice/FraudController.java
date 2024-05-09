package org.rabini.fraudservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
@AllArgsConstructor
public class FraudController {
	
	private final FraudCheckService fraudCheckService;
	
	
	@GetMapping(path= "{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customeId) {
		boolean isFraudlent=fraudCheckService.isFraudulentCustomer(customeId);
		log.info("fraud check request for customer {}",customeId);
		return new FraudCheckResponse(isFraudlent);
	}

}
