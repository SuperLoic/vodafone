package com.vodafone.controller;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import com.vodafone.entity.ICustomer;

public class ICustomerControllerTest {
	CustomerController customerController;

	@Before
	public void init() {
		customerController = new CustomerController();
	}

	/**
	 * Feature - create customer with details and return it
	 */
	@Test
	public void create() {
		// Given
		String name = "Mark";
		String address = "Auckland";
		String telephoneNumber = "0211616447";

		// When
		ICustomer customer = customerController.create(name, address, telephoneNumber);

		// Then
		Assert.assertNotNull(customer);
	}

	/**
	 * Feature - read all customers
	 */
	@Test
	public void readAllCustomers() {
		// Given
		int originalLength = customerController.read().size();
		String name = "Leo";
		String address = "Auckland";
		String telephoneNumber = "021123728381";
		customerController.create(name, address, telephoneNumber);
		name = "Mark";
		address = "Auckland";
		telephoneNumber = "0211616447";
		customerController.create(name, address, telephoneNumber);

		// When
		List<ICustomer> list = customerController.read();

		// Then
		int expected = originalLength + 2;
		int actual = list.size();
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Feature - read customer by id
	 */
	@Test
	public void readCustomerById() {
		String name = "Leo";
		String address = "Auckland";
		String telephoneNumber = "021123728381";
		ICustomer customer = customerController.create(name, address, telephoneNumber);
		long id = customer.getId();
		name = "Mark";
		address = "Auckland";
		telephoneNumber = "0211616447";
		customerController.create(name, address, telephoneNumber);

		// When
		ICustomer cus = customerController.read(id);

		// Then
		Assert.assertEquals(customer, cus);
	}

	/**
	 * Feature - delete customer by customer id and return it
	 */
	@Test
	public void deleteCustomer() {

		// Given
		String name = "Leo";
		String address = "Auckland";
		String telephoneNumber = "021123728381";
		ICustomer customer = customerController.create(name, address, telephoneNumber);
		long id = customer.getId();
		int originalLength = customerController.read().size();

		// When
		ICustomer cus = customerController.delete(id);

		// Then
		int expected = originalLength - 1;
		int actual = customerController.read().size();
		Assert.assertEquals(expected, actual);
		Assert.assertNotNull(cus);
	}

	/**
	 * Feature - update customer and return it
	 */
	@Test
	public void updateCustomer() {
		// Given
		String name = "Leo";
		String address = "Auckland";
		String telephoneNumber = "021123728381";
		ICustomer customer = customerController.create(name, address, telephoneNumber);
		name = "Mark";
		address = "Auckland";
		telephoneNumber = "0211616447";
		long id = customer.getId();

		// When
		ICustomer cus = customerController.update(id, name, address, telephoneNumber);

		// Then
		Assert.assertEquals(name, cus.getName());
		Assert.assertEquals(address, cus.getAddress());
		Assert.assertEquals(telephoneNumber, cus.getTelephoneNumber());
		Assert.assertEquals(id, cus.getId());
	}

	@After
	public void destroy() {
		customerController = null;
	}
}
