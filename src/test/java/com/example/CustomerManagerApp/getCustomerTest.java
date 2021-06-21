package com.example.CustomerManagerApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.app.bean.CustomerBean;
import com.demo.app.customerService.JpaService;
import com.demo.app.dao.CustomerRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class getCustomerTest {

	@Autowired
	JpaService jpaService;

	@MockBean
	CustomerRepo repo;

	@Test
	@DisplayName("getAllCustomerDetails")
	public void getAllCustomerDetailsTest() {

		List<CustomerBean> list = new ArrayList<>();
		CustomerBean b1 = new CustomerBean(5, "TestUser", 99);
		CustomerBean b2 = new CustomerBean(5, "TestUser", 99);
		when(repo.findAll()).thenReturn(list);
		assertEquals(2, jpaService.getAllCustomerDetails().size());
	}

}
