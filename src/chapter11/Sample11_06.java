/**
 * 
 */
package chapter11;
import java.sql.*;

/**
 * @author Riki
 * Statementインタフェースの様々なメソッド
 * executeUpdate delete
 */
public class Sample11_06 {
	public static void main(String[]args){
		String sql = "delete from department where dept_code = 6";
		try(Connection con = DBConnector.getConnect();
				Statement stmt = con.createStatement()){
			int col = stmt.executeUpdate(sql);
			System.out.println("col:" + col);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
