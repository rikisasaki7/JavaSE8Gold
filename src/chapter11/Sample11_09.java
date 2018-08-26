/**
 * 
 */
package chapter11;
import java.sql.*;

/**
 * @author Riki
 * ResultSetインタフェースの拡張
 * absoluteメソッド
 */
public class Sample11_09 {
	public static void main(String[]args){
		String sql = "select dept_code from department order by dept_code";
		try(Connection con = DBConnector.getConnect();
				Statement stmt = con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE
						, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql)){
			rs.absolute(1);
			System.out.println(rs.getString(1));
			rs.absolute(-1); // マイナスの場合は後ろから数える
			System.out.println(rs.getString(1));
			rs.absolute(-2);
			System.out.println(rs.getString(1));
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
