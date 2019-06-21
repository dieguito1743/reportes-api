package pe.com.hiper.hcenter2.reportes.dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UserCache {

	private String sCodUser;
	private ResultSet rsResultSet;
	private ResultSetMetaData rsmResultSetMetaData;
	private Connection cConnection;

	public UserCache() {

	}

	public UserCache(String sCodUser, ResultSet rsResultSet, Connection cConnection) {
		this.sCodUser = sCodUser;
		this.rsResultSet = rsResultSet;
		this.cConnection = cConnection;
	}

	public String getCodUser() {
		return sCodUser;
	}

	public void setCodUser(String sCodUser) {
		this.sCodUser = sCodUser;
	}

	public ResultSet getResultSet() {
		return rsResultSet;
	}

	public void setResultSet(ResultSet rsResultSet) throws SQLException {
		if (rsResultSet != null) {
			rsmResultSetMetaData = rsResultSet.getMetaData();
		}
		this.rsResultSet = rsResultSet;
	}

	public Connection getConnection() {
		return cConnection;
	}

	public void setConnection(Connection cConnection) {
		this.cConnection = cConnection;
	}

	public int getNumberOfColumn() throws SQLException {
		if (rsmResultSetMetaData == null)
			rsmResultSetMetaData = rsResultSet.getMetaData();
		if (rsmResultSetMetaData != null) {
			return rsmResultSetMetaData.getColumnCount();
		}
		return 0;
	}

}
