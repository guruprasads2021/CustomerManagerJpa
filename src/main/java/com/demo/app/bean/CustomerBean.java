package com.demo.app.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CUSTOMERS")
public class CustomerBean implements Serializable {

	@Id
	private int customerId;
	private String name;
	private int Age;
	@Column(name = "CREATED_DATE", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Age;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerBean other = (CustomerBean) obj;
		if (Age != other.Age)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (customerId != other.customerId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", name=" + name + ", Age=" + Age + ", createdDate="
				+ createdDate + "]";
	}
	public CustomerBean(int customerId, String name, int age, Date createdDate) {
		super();
		this.customerId = customerId;
		this.name = name;
		Age = age;
		this.createdDate = createdDate;
	}
	
	public CustomerBean(int customerId, String name, int age) {
		super();
		this.customerId = customerId;
		this.name = name;
		Age = age;
	}
	public CustomerBean() {
		super();
	}
	
		
	
}
