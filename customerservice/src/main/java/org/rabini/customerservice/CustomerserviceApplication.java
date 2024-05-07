package org.rabini.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan(basePackages = { "org.rabini.customerservice" })
public class CustomerserviceApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(CustomerserviceApplication.class, args);
	}

}
