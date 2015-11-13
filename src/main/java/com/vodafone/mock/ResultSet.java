package com.vodafone.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import com.vodafone.entity.Customer;
import com.vodafone.entity.ICustomer;

/**
 * <code>ResultSet</code> simulate the database CRUD operations
 * 
 * @author Mark
 *
 */
public class ResultSet {
	private ConcurrentMap<Long, ICustomer> CUSTOMERS = new ConcurrentHashMap<Long, ICustomer>();
	private AtomicLong counter = new AtomicLong();

	public ResultSet() {
		this(0);
	}

	/**
	 * Construction with amount of customers generated
	 * 
	 * @param amount
	 *            customer amount
	 */
	public ResultSet(int amount) {
		for (int i = 0; i < amount; i++) {
			long id = counter.incrementAndGet();
			CUSTOMERS.put(id, new Customer(id, "Name" + i, "Address" + i, "Phone" + i));
		}
	}

	/**
	 * Generate id
	 * 
	 * @return id
	 */
	public long generateId() {
		return counter.incrementAndGet();
	}

	/**
	 * List customer collection
	 * 
	 * @return customer dataset
	 */
	public List<ICustomer> listCustomers() {
		List<ICustomer> ls = new ArrayList<ICustomer>();
		ls.addAll(CUSTOMERS.values());
		return ls;
	}

	/**
	 * Query customer by id
	 * 
	 * @param id customer id
	 * @return customer
	 */
	public ICustomer queryCustomer(long id) {
		return CUSTOMERS.get(id);
	}

	/**
	 * Create new customer
	 * 
	 * @param customer
	 *            new customer
	 * @return created customer
	 */
	public ICustomer createCustomer(ICustomer customer) {
		CUSTOMERS.put(customer.getId(), customer);
		return customer;
	}

	/**
	 * Update customer
	 * 
	 * @param customer
	 *            up to date customer
	 * @return updated customer
	 */
	public ICustomer updateCustomer(ICustomer customer) {
		ICustomer cus = CUSTOMERS.get(customer.getId());
		if (null == cus || null == customer) {
			return null;
		}
		CUSTOMERS.replace(customer.getId(), cus, customer);
		return customer;
	}

	/**
	 * Remove customer
	 * 
	 * @param customer
	 *            customer
	 * @return removed customer
	 */
	public ICustomer deleteCustomer(ICustomer customer) {
		return deleteCustomer(customer.getId());
	}

	/**
	 * Remove customer by id
	 * 
	 * @param id
	 *            customer id
	 * @return removed customer
	 */
	public ICustomer deleteCustomer(long id) {
		return CUSTOMERS.remove(id);
	}

	/**
	 * Get customers' size
	 * 
	 * @return size of customers
	 */
	public int size() {
		return CUSTOMERS.size();
	}

}
