/**
 * 
 */
package chapter11;

import java.sql.*;

/**
 * @author Riki
 * Statementインタフェースの様々なメソッド
 * executeUpdate insert
 */
public class Sample11_04 {
	
	public static void main(String[]args){
		String sql = "insert into department values(6, 'Planning', 'Yokohama', '045-333-1111')";
		try(Connection con = DBConnector.getConnect();
				Statement stmt = con.createStatement()){
			int col = stmt.executeUpdate(sql);
			System.out.println("col:" + col);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
