/*
 * @author Merijn
 * 
 */

package Storage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class Database {
	

	BoneCP connectionPool = null;
	Connection connection = null;
	
	public void Init() {
		// We're going to initialise the database connection
		// With BoneCP
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl("jdbc:mysql//localhost");
			config.setUsername("root");
			config.setPassword("lolwutpwn");
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(1);
			
			connectionPool = new BoneCP(config);
			
			connection = connectionPool.getConnection();
			
			
			if (connection != null) {
				// Connected :D
				
				System.out.println("BoneCP initialised. Database connection successfull.");
			
			}
			
			connectionPool.shutdown();
			
		} catch (SQLException e) {
			
			System.out.println("Oops.. An error LOL!");
			e.printStackTrace();
		} finally {
			
			if (connection != null) {
				
				try {
					
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void prepareQuery(String query) {
		
		/**
		 * Using prepared statements to do queries etc.
		 */
		
		try {
			PreparedStatement preStatement = connection.prepareStatement(query);
			
		} catch (SQLException e) {
			// Something went wrong :o
			
			e.printStackTrace();
		}
		
		
	}
	
	public void executePrepared(Integer[] keys, String[] value) {
		
		/**
		 * TODO:
		 * - Execute the prepared statement.
		 * - Let him do what he wants to do.
		 */
		
		
	}
 
}
