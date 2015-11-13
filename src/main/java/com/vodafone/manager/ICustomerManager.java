package com.vodafone.manager;

import java.util.List;

import com.vodafone.entity.ICustomer;

/**
 * <code>ICustomerManager</code> provides CRUD services for customer data.
 * <ul>
 * <li>create - create a new customer</li>
 * <li>read - list all the customers</li>
 * <li>update - update customer by up date customer</li>
 * <li>delete - delete customer by id</li>
 * </ul>
 * @author Mark
 *
 */
public interface ICustomerManager {
	
	/**
	 * Create customer
	 * @param customer customer
	 * @return created customer
	 */
	public ICustomer create(ICustomer customer);

	/**
	 * Read all customers
	 * @return customers
	 */
	public List<ICustomer> read();
	
	/**
	 * Read customer by id
	 * @param id customer id
	 * @return customer
	 */
	public ICustomer read(long id);

	/**
	 * Update customer
	 * @param customer customer
	 * @return updated customer
	 */
	public ICustomer update(ICustomer customer);

	/**
	 * Delete customer
	 * @param id customer id
	 * @return deleted customer
	 */
	public ICustomer delete(long id);
	
}
