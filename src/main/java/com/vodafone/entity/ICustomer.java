package com.vodafone.entity;

/**
 * Customer POJO
 * 
 * @author Mark
 *
 */
public interface ICustomer {

	/**
	 * Get customer id
	 * 
	 * @return customer id
	 */
	public long getId();

	/**
	 * Set customer id
	 * 
	 * @param id
	 *            customer id
	 */
	public void setId(long id);

	/**
	 * Get customer name
	 * 
	 * @return customer name
	 */
	public String getName();

	/**
	 * Set customer name
	 * 
	 * @param name
	 *            customer name
	 */
	public void setName(String name);

	/**
	 * Get customer address
	 * 
	 * @return customer address
	 */
	public String getAddress();

	/**
	 * Set customer address
	 * 
	 * @param address
	 *            customer address
	 */
	public void setAddress(String address);

	/**
	 * Get customer telephone number
	 * 
	 * @return customer telephone number
	 */
	public String getTelephoneNumber();

	/**
	 * Set customer telephone number
	 * 
	 * @param telephoneNumber
	 *            customer telephone number
	 */
	public void setTelephoneNumber(String telephoneNumber);
}
