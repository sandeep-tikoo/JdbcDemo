package org.arnav.javabrains.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.arnav.javabrains.jdbc.model.bwTxnsModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BwTxnsMapper implements RowMapper<bwTxnsModel>{

	@Override
	public bwTxnsModel mapRow(ResultSet rs, int rowNo) throws SQLException {
		
		bwTxnsModel bwTxnsInstance = null;
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
		return bwTxnsInstance;
	}
}
