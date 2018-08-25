package org.arnav.javabrains.jdbc.dao;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.arnav.javabrains.jdbc.model.bwTxnsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class jdbcDaoImpl {
	
	@Autowired
	private DataSource dataSource;
	
//	private static final String URL   = "jdbc:mysql://localhost:3306/deepu";
//	private static final String USER  = "root";
//	private static final String PASS  = "password";
	
	public bwTxnsModel getTxn(int txnId)	{
    		
    		try	
    			(
//    				Connection conn = DriverManager.getConnection(URL, USER, PASS);
    				Connection conn = dataSource.getConnection();
    				Statement stmt = conn.createStatement();
    				ResultSet rs = stmt.executeQuery("SELECT * FROM bw_txn where bw_txn_id = " + txnId + ";");
    			)
    		{
//                System.out.println("Connected to: " + dataSource.get);
     			bwTxnsModel bwTxnsInstance = null;
     			while (rs.next()) {
     				bwTxnsInstance = new bwTxnsModel(
     						  rs.getInt("bw_txn_id")
     						, rs.getString("BSB_Number")
     						, rs.getInt("Account_Number")
     						, rs.getString("Transaction_Date")
     						, rs.getString("Narration")
     						, rs.getString("Cheque_Number")
     						, rs.getDouble("Debit")
     						, rs.getDouble("Credit")
     						, rs.getDouble("Balance")
     						, rs.getString("Transaction_Type")
     						);
     			}
     			return bwTxnsInstance;
            } 
    		catch (SQLException e) {
                System.out.println("SQLException: "+ e.getMessage());
                System.out.println("SQLState: "+ e.getSQLState());
                System.out.println("VendorError: "+ e.getErrorCode());
                return null;
            }
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
