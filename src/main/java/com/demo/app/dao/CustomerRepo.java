package com.demo.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.app.bean.CustomerBean;

@Repository
public interface CustomerRepo extends CrudRepository<CustomerBean, Integer> {

	@Query(value="select CUSTOMER_ID,NAME,AGE,CREATED_DATE from customers where AGE>?1", nativeQuery=true)
	List<CustomerBean> findAllSeniorCitizens(int age);
}

