package com.vodafone.manager;

import java.util.List;

import com.vodafone.entity.ICustomer;
import com.vodafone.mock.ResultSet;

/**
 * Implementation of ICustomerManager
 * 
 * @author Mark
 *
 */
public class CustomerManager implements ICustomerManager {
	private ResultSet rs;

	public CustomerManager(ResultSet rs) {
		this.rs = rs;
	}

	@Override
	public ICustomer create(ICustomer customer) {
		return rs.createCustomer(customer);
	}

	@Override
	public List<ICustomer> read() {
		return rs.listCustomers();
	}

	@Override
	public ICustomer update(ICustomer customer) {
		return rs.updateCustomer(customer);
	}

	@Override
	public ICustomer delete(long id) {
		return rs.deleteCustomer(id);
	}

	@Override
	public ICustomer read(long id) {
		return rs.queryCustomer(id);
	}
}
