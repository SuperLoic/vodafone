package com.vodafone.controller;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.entity.Customer;
import com.vodafone.entity.ICustomer;
import com.vodafone.manager.CustomerManager;
import com.vodafone.manager.ICustomerManager;
import com.vodafone.mock.ResultSet;

/**
 * Implementation of ICustomerController, provide CRUD Rest services
 * 
 * @author Mark
 *
 */
@SpringBootApplication
@RestController
public class CustomerController implements ICustomerController {
	private ICustomerManager customerManager;
	private ResultSet rs;

	/**
	 * Get customers
	 * 
	 * @return customers
	 */
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	@Override
	public List<ICustomer> read() {
		return customerManager.read();
	}

	/**
	 * Get customer by id
	 * 
	 * @param id
	 *            customer id
	 * @return customer
	 */
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	@Override
	public ICustomer read(@PathVariable long id) {
		return customerManager.read(id);
	}

	/**
	 * Update customer
	 * 
	 * @param customer
	 *            new customer
	 * @return created customer
	 */
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ICustomer create(@RequestBody Customer customer) {
		if (customer != null) {
			customer.setId(rs.generateId());
		}
		return customerManager.create(customer);
	}
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/customer", method = RequestMethod.PUT)
	public ICustomer update(@RequestBody Customer customer) {
		return customerManager.update(customer);
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	@Override
	public ICustomer delete(@PathVariable long id) {
		return customerManager.delete(id);
	}

	public ICustomer update(long id, String name, String address, String telephoneNumber) {
		return update(new Customer(id, name, address, telephoneNumber));
	}

	public ICustomer create(String name, String address, String telephoneNumber) {
		return create(new Customer(rs.generateId(), name, address, telephoneNumber));
	}

	public CustomerController() {
		rs = new ResultSet(0);
		customerManager = new CustomerManager(rs);
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerController.class, args);
	}
}
