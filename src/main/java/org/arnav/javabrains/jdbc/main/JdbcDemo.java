package org.arnav.javabrains.jdbc.main;

import org.arnav.javabrains.jdbc.dao.jdbcDaoImpl;
import org.arnav.javabrains.jdbc.model.bwTxnsModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		jdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", jdbcDaoImpl.class);
		
		//Get row count
		System.out.println("Count from getTxnCount method: " + dao.getTxnCount());
		
		//Get row by ID
		bwTxnsModel newTxn1 = dao.getTxn(2);
		System.out.println("An instance for get ID method: " + newTxn1.getTxnId() + " <:> " + newTxn1.getBalance());

		System.out.println("Size from get list method array: " + dao.getTxnList().size());

		
	}

}
