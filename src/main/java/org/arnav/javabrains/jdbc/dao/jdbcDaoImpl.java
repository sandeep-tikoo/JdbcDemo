package org.arnav.javabrains.jdbc.dao;
//import java.sql.DriverManager;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.arnav.javabrains.jdbc.model.bwTxnsModel;
import org.arnav.javabrains.jdbc.rowmapper.BwTxnsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class jdbcDaoImpl {
	
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public int getTxnCount()	{
		String sql = "select count(*) from bw_txn";
//		jdbcTemplate.setDataSource(getDataSource());
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
	public bwTxnsModel getTxn(int txnId)	{
		String sql = "select * from bw_txn where bw_txn_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {txnId}, new BwTxnsMapper());
	}
	
	public List<bwTxnsModel> getTxnList()	{
		String sql = "select * from bw_txn";
		return jdbcTemplate.query(sql, new BwTxnsMapper());
	}
	
	public void insertBwTxn(bwTxnsModel nR)	{
		System.out.println("Befor SQL prepare");
		String sql = "INSERT INTO bw_txn (bw_txn_id, BSB_Number, Account_Number, Transaction_Date, Narration, Cheque_Number, "
				+ "Debit, Credit, Balance, Transaction_Type) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("After SQL prepare");
		jdbcTemplate.update(sql, new Object[] {nR.getTxnId()
												,nR.getBSBNumber()
												,nR.getAccountNumber()
												,nR.getTxnDate()
												,nR.getNarration()
												,nR.getChqNo()
												,nR.getDebitAmount()
												,nR.getCreditAmount()
												,nR.getBalance()
												,nR.getTxnType()}
							);
		System.out.println("Befor SQL Execute");
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
