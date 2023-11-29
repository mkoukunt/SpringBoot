package org.rabini.customerservice;

public record  CustomerRegistrationRequest( 
	String firstName,
	String lastName,
	String email)
	{
}
