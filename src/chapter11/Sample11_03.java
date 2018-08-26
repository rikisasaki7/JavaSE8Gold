/**
 * 
 */
package chapter11;

import java.sql.*;

/**
 * @author Riki
 * Statementインタフェースの様々なメソッド
 * executeQuery
 */
public class Sample11_03 {
	
	public static void main(String[]args){
		String sql = "select dept_name from department where dept_code = 4";
		try(Connection con = DBConnector.getConnect();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			if(rs != null) System.out.println("rs != null"); // レコードが０件の場合も、nullにはならない。空のresultsetを返す
			if(rs.next()){ // レコードが０件の場合はfalseを返す
				System.out.println("dept_name: " + rs.getString("dept_name"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

}
