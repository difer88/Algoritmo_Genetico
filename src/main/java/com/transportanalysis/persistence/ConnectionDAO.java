package main.java.com.transportanalysis.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

import main.java.com.transportanalysis.enumeration.DatabaseSettings;

public class ConnectionDAO {
	
	protected Connection con;
	protected PreparedStatement stmt;
	protected CallableStatement call;
	protected ResultSet rs;
	
	private final static Logger LOGGER = Logger.getLogger(ConnectionDAO.class.getName());
	
	protected void openConnection() {
		if(con == null) {
			try {
				Class.forName(DatabaseSettings.DRIVER.getValue());
				con = DriverManager.getConnection(DatabaseSettings.URL.getValue(), 
						DatabaseSettings.USER.getValue(), DatabaseSettings.PASSWORD.getValue());
			} catch (Exception e) {
				LOGGER.info("Erro: " + e.getMessage());
			}
		}
	}
	
	protected void closeConnection() {
		try {
			if(con != null){
				con.close();
			}
		} catch (Exception e) {
			LOGGER.info("Erro: " + e.getMessage());
		}
	}
}
