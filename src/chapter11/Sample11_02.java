/**
 * 
 */
package chapter11;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Riki
 * JDBCを使用したDB接続
 * dateTimeAPIを使用した例
 */
public class Sample11_02 {

	public static void main(String[]args){
		
		String url = "jdbc:mysql://localhost:3306/golddb";
//		String sql = "select * from mytableA";
		String sql = "select * from mytableAAAA"; // わざとSQLExceptionを発生させる
		// try-with-resourceを使ってみた
		try(Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()){
				Date sqlDate = rs.getDate(1);
				LocalDate localDate = sqlDate.toLocalDate();
				System.out.println("localDate:[" + localDate + "]");
				
				Time sqlTime = rs.getTime(2);
				LocalTime localTime = sqlTime.toLocalTime();
				System.out.println("localTime:[" + localTime + "]");
				
				Timestamp timestamp = rs.getTimestamp(3);
				LocalDateTime localDateTime = timestamp.toLocalDateTime();
				System.out.println("localDateTime:[" + localDateTime + "]");
			}
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("ErrorCode:" + e.getErrorCode());
			System.out.println("SQLState:" + e.getSQLState());
		} 
	}
}
