package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import enumeration.DatabaseSettings;

public class ConnectionDAO {
	
	protected Connection con;
	protected PreparedStatement stmt;
	protected CallableStatement call;
	protected ResultSet rs;
	
	protected void openConnection() throws Exception{
		if(con != null) {
			Class.forName(DatabaseSettings.DRIVER.getValue());
			con = DriverManager.getConnection(DatabaseSettings.URL.getValue(), 
					DatabaseSettings.USER.getValue(), DatabaseSettings.PASSWORD.getValue());
		}
	}
	
	protected void closeConnection() throws Exception{
		if(con != null){
			con.close();
		}
	}
}
