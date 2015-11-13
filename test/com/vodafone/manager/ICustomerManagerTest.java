package com.vodafone.manager;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.vodafone.entity.Customer;
import com.vodafone.entity.ICustomer;
import com.vodafone.mock.ResultSet;

/**
 * ICustomerManager API Testcases
 * 
 * @author Mark
 *
 */
public class ICustomerManagerTest {

	/**
	 * Feature - be able to read all customers
	 */
	@Test
	public void read() {
		// Given
		int expected = 10; // default generate amount

		// When
		ResultSet rs = new ResultSet(expected);
		Collection<ICustomer> customers = rs.listCustomers();

		// Then
		int actual = customers.size();
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Feature - be able to read customer by id
	 */
	public void readById() {
		// Given
		String name = "Mark";
		String address = "Auckland";
		String telephoneNumber = "0211616447";
		ResultSet rs = new ResultSet();
		ICustomer customer = rs.createCustomer(new Customer(rs.generateId(), name, address, telephoneNumber));
		long id = customer.getId();
		
		// When 
		ICustomer cus = rs.queryCustomer(id);
		
		// Then
		Assert.assertEquals(id, cus.getId());
	}
	
	

	/**
	 * Feature - be able to create a customer by instance and return the created customer
	 */
	@Test
	public void create() {
		// Given
		String name = "Mark";
		String address = "Auckland";
		String telephoneNumber = "0211616447";

		// When
		ResultSet rs = new ResultSet();
		int originalSize = rs.size();
		long id = rs.generateId();
		ICustomer customer = new Customer(id, name, address, telephoneNumber);
		ICustomer cus = rs.createCustomer(customer);

		// Then
		int expected = originalSize + 1;
		int actual = rs.size();
		Assert.assertEquals(expected, actual);
		Assert.assertNotNull(cus);
	}
	
	/**
	 * Feature - be able to delete the customer by instance and return deleted customer
	 */
	@Test
	public void delete() {
		// Given
		int originalSize = 10;
		ResultSet rs = new ResultSet(originalSize);
		ICustomer customer = rs.listCustomers().get(1);

		// When
		ICustomer cus = rs.deleteCustomer(customer);

		// Then
		int expected = originalSize - 1;
		int actual = rs.size();
		Assert.assertEquals(expected, actual);
		Assert.assertNotNull(cus);
	}
	
	/**
	 * Feature - be able to update customer by instance and return updated customer
	 */
	@Test
	public void update() {
		// Given
		ResultSet rs = new ResultSet();
		long id = rs.generateId();
		String name = "Mark";
		String address = "Auckland";
		String telephoneNumber = "0211616447";
		ICustomer customer = new Customer(id, name, address, telephoneNumber);
		rs.createCustomer(customer);
		String newTelephoneNumber = "0211111111"; // new telephone number
		int originalLength = rs.size();

		// When
		customer.setTelephoneNumber(newTelephoneNumber);
		ICustomer cus = rs.updateCustomer(customer);

		// Then
		int expected = originalLength;
		int actual = rs.size();
		Assert.assertEquals(expected, actual);
		Assert.assertNotNull(cus);
	}

}
