package org.rabini.customerservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
@AllArgsConstructor
public class CustomerController
{
	private final CustmerSrvice service;

	@PostMapping
	public void registerCustomer(@RequestBody CustomerRegistrationRequest req)
	{
		log.info("new Cusomere regidtration {} ", req);
		service.registerCustomer(req);
	}

}
