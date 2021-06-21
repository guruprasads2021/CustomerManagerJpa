package com.demo.app.customerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.demo.app.bean.CustomerBean;
import com.demo.app.dao.CustomerRepo;

@Component
public class JpaService {

	@Autowired
	CustomerRepo customerRepo;
	
	public List<CustomerBean> getAllCustomerDetails(){
		List<CustomerBean> customersList = new ArrayList<CustomerBean>();
		customerRepo.findAll().forEach(customersList::add);
		return customersList;
	}
	
	public CustomerBean saveCustomerDetails(CustomerBean customerObj){
		return customerRepo.save(customerObj);
	}

	public Optional<CustomerBean> getCustomerDetails(String customerId) {
		return customerRepo.findById(Integer.parseInt(customerId));
	}

	public void deleteCustomerDetails(String customerNumber) {
		
		customerRepo.deleteById(Integer.parseInt(customerNumber));
		
	}

	public List<CustomerBean> getAllSeniorCustomerDetails() {

		List<CustomerBean> customersList = new ArrayList<CustomerBean>();
		customerRepo.findAllSeniorCitizens(60).forEach(customersList::add);
		return customersList;
	}
	
}
