package com.vodafone.controller;

import java.util.List;

import com.vodafone.entity.ICustomer;

/**
 * <code>ICustomerController</code> provides CRUD RESTful services for customer
 * data.
 * <ul>
 * <li>create - create a new customer</li>
 * <li>read - list all the customers</li>
 * <li>update - update customer</li>
 * <li>delete - delete customer by id</li>
 * </ul>
 * 
 * 
 * @author Mark
 *
 */
public interface ICustomerController {
	/**
	 * Create customer
	 * 
	 * @param name
	 *            customer name
	 * @param address
	 *            customer address
	 * @param telephoneNumber
	 *            customer telephone number
	 * @return customer instance
	 */
	public ICustomer create(String name, String address, String telephoneNumber);

	/**
	 * Read all customers
	 * 
	 * @return all customers
	 */
	public List<ICustomer> read();

	/**
	 * Read customer by id
	 * 
	 * @param id
	 *            customer id
	 * @return customer instance
	 */
	public ICustomer read(long id);

	/**
	 * Update customer
	 * 
	 * @param id
	 *            customer id
	 * @param name
	 *            customer name
	 * @param address
	 *            customer address
	 * @param telephoneNumber
	 *            customer telephone numbers
	 * @return updated customer instance
	 */
	public ICustomer update(long id, String name, String address, String telephoneNumber);

	public ICustomer delete(long id);
}
