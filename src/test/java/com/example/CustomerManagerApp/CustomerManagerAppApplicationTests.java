package com.example.CustomerManagerApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.app.bean.CustomerBean;
import com.demo.app.customerService.JpaService;

@SpringBootTest
class CustomerManagerAppApplicationTests {

	@Autowired
	JpaService jpaService;


	@Test
	@DisplayName("getCustomerDetails")
	public void getCustomerTest() {
		
		Optional<CustomerBean> bean = jpaService.getCustomerDetails("1");
		System.out.println("bean:"+bean);
		assertNotNull(bean);
	}
}
