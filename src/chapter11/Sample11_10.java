/**
 * 
 */
package chapter11;
import java.sql.*;

/**
 * @author Riki
 * ResultSetインタフェースの拡張
 * 更新
 */
public class Sample11_10 {
	
	public static void main(String[]args){
		String sql = "select dept_code, dept_address, dept_name from department where dept_code = 4";
		try(Connection con = DBConnector.getConnect();
				Statement stmt = con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE
						, ResultSet.CONCUR_UPDATABLE);
						ResultSet rs = stmt.executeQuery(sql)){
			if(rs.next()) System.out.println(rs.getString(2));
			rs.updateString(2, "Chiva");
			rs.updateRow();
			
			// insertの場合
			rs.moveToInsertRow(); // 挿入用の行に移動
			rs.updateInt(1, 11);
			rs.updateString(2, "tokushima");
			rs.updateString(3, "sales");
			rs.insertRow();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
