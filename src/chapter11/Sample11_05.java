/**
 * 
 */
package chapter11;
import java.sql.*;

/**
 * @author Riki
 * Statementインタフェースの様々なメソッド
 * executeUpdate update
 */
public class Sample11_05 {

	public static void main(String[]args){
		String sql = "update department set dept_name = 'updated!!' where dept_code = 5";
		try(Connection con = DBConnector.getConnect();
				Statement stmt = con.createStatement()){
			int col = stmt.executeUpdate(sql);
			System.out.println("col:" + col);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
