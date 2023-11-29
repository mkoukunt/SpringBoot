package org.rabini.customerservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustmerSrvice {
private final CustomerRepository cr;
private final RestTemplate rt;
	public void registerCustomer(CustomerRegistrationRequest req) {
		Customer c = Customer.builder().firstName(req.firstName()).lastName(req.lastName()).email(req.email()).build();
		cr.saveAndFlush(c);
		FraudCheckResponse res=rt.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}", FraudCheckResponse.class,c.getId());
	cr.save(c);
	}

}
