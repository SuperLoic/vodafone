package com.vodafone.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Implementation of ICustomer
 * 
 * @author Mark
 *
 */
@XmlRootElement
public class Customer implements ICustomer {
	private long id; // customer id
	private String name; // customer name
	private String address; // customer address
	private String telephoneNumber; // customer telephone number

	public Customer() {
	}

	public Customer(String name, String address, String telephoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}

	public Customer(long id, String name, String address, String telephoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	@Override
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}
}
