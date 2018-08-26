/**
 * 
 */
package chapter11;
import java.sql.*;

/**
 * @author Riki
 * Statementインタフェースの様々なメソッド
 * execute
 */
public class Sample11_07 {
	
	public static void main(String[]args){
		
		// 複数のSQL文
		String[] sqls = {
				"insert into department values(7, 'Plannning', 'yokohama', '090-0000-0000')"
				, "select dept_name from department where dept_code = 2"
		};
		try(Connection con = DBConnector.getConnect();
				Statement stmt = con.createStatement()){
			for(String sql : sqls){
				boolean isResultSet = stmt.execute(sql);
				if(isResultSet){
					ResultSet rs = stmt.getResultSet();
					rs.next();
					System.out.println("dept_name: " + rs.getString("dept_name"));
				} else {
					int col = stmt.getUpdateCount();
					System.out.println("col:" + col);
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
