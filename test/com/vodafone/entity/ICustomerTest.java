package com.vodafone.entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ICustomer API Testcases
 * 
 * @author Mark
 *
 */
public class ICustomerTest {

	long id = 1;
	String name = "Mark";
	String address = "Auckland";
	String telephoneNumber = "0211616447";
	ICustomer customer;

	@Before
	public void init() {
		customer = new Customer(id, name, address, telephoneNumber);
	}
	
	/**
	 * Feature - be able to get customer id
	 */
	@Test
	public void getId() {
		// When
		long id = customer.getId();

		// Then
		Assert.assertEquals(this.id, id);
	}
	
	/**
	 * Feature - be able to set customer id
	 */
	@Test
	public void setId() {
		// Given
		long newId = 2;

		// When
		customer.setId(newId);

		// Then
		Assert.assertEquals(newId, customer.getId());
	}
	
	/**
	 * Feature - be able to get customer name
	 */
	@Test
	public void getName() {
		// When
		String name = customer.getName();

		// Then
		Assert.assertEquals(this.name, name);
	}
	
	/**
	 * Feature - be able to set customer name
	 */
	@Test
	public void setName() {
		// Given
		String newName = "Leo";

		// When
		customer.setName(newName);

		// Then
		Assert.assertEquals(newName, customer.getName());
	}
	
	/**
	 * Feature - be able to get customer address
	 */
	@Test
	public void getAddress() {
		// When
		String address = customer.getAddress();

		// Then
		Assert.assertEquals(this.address, address);
	}
	
	/**
	 * Feature - be able to set customer address
	 */
	@Test
	public void setAddress() {
		// Given
		String newAddress = "Hamilton";

		// When
		customer.setAddress(newAddress);

		// Then
		Assert.assertEquals(newAddress, customer.getAddress());
	}

	/**
	 * Feature - be able to get customer telephone number
	 */
	@Test
	public void getTelephoneNumber() {
		// When
		String telephoneNumber = customer.getTelephoneNumber();

		// Then
		Assert.assertEquals(this.telephoneNumber, telephoneNumber);
	}
	
	/**
	 * Feature - be able to set customer telephone number
	 */
	@Test
	public void setTelephoneNumber() {
		// Given
		String newTelephoneNumber = "0211111111";

		// When
		customer.setTelephoneNumber(newTelephoneNumber);

		// Given
		Assert.assertEquals(newTelephoneNumber, customer.getTelephoneNumber());
	}
	
	@After
	public void destroy(){
		customer = null;
	}

}
