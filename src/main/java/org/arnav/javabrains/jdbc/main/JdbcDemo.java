package org.arnav.javabrains.jdbc.main;

import org.arnav.javabrains.jdbc.dao.jdbcDaoImpl;
import org.arnav.javabrains.jdbc.model.bwTxnsModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		jdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", jdbcDaoImpl.class);
		
		bwTxnsModel newTxn = dao.getTxn(2);
		System.out.println(newTxn.getTxnId() + " <:> " + newTxn.getBalance());

	}

}
