package com.demo.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.bean.Customer;
import com.demo.app.bean.CustomerBean;
import com.demo.app.customerService.CustomerService;
import com.demo.app.customerService.JpaService;
import com.google.gson.Gson;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	JpaService jpaService;
	
	/*
	 * @GetMapping(path = "/") public String home() {
	 * System.out.println(" insidecustomer controller"); return "home"; }
	 */
	
	/*@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<Object> getAllCustomer() {
			
			List<CustomerBean> response = jpaService.getAllCustomerDetails();
			return new ResponseEntity<Object>(response, HttpStatus.OK);
		}
	
	*/
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> saveCustomerDetails(@RequestBody CustomerBean customerObj) {
		
		CustomerBean response = jpaService.saveCustomerDetails(customerObj);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	/*@PutMapping(path = "/customer/{customerId}", consumes = "application/json", produces = "application/json")
	public String updateCustomerDetails(@RequestBody Customer customerObj, @PathVariable String customerId) {
		
		Map<String, Object> resultMap = customerService.updateCustomerDetails(customerId,customerObj);
		
		return new Gson().toJson(resultMap);
	}*/
	
	@GetMapping(path = "/{customerId}", produces = "application/json")
	public ResponseEntity<Object> getCustomer(@PathVariable String customerId) {
		
		Optional<CustomerBean> response = jpaService.getCustomerDetails(customerId);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{customerNumber}", produces = "application/json")
	public void deleteCustomerDetails(@PathVariable String customerNumber) {
		
		jpaService.deleteCustomerDetails(customerNumber);
	}
	
	@GetMapping(path = "/seniorCustomer", produces = "application/json")
	public ResponseEntity<Object> getSeniorCustomerDetails() {
		
		List<CustomerBean> response = jpaService.getAllSeniorCustomerDetails();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
