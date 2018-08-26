/**
 * 
 */
package chapter11;

import java.sql.*;

/**
 * @author Riki
 *
 */
public class DBConnector {

	public static Connection getConnect() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/golddb";
		return DriverManager.getConnection(url, "root", "");
	}
}
