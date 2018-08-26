/**
 * 
 */
package chapter11;

import java.sql.*;

/**
 * @author Riki
 * JDBCを使用したDB接続
 * ※事前に以下設定済み
 * 　１.mysqlのドライバjarファイルをlibフォルダに格納
 * 　２.classパスに設定
 * 　３.mysqlをxampから起動し、DBとテーブルとデータ作成済み
 * 
 * *urlの構文は以下の通り
 * 　jdbc:<subprotocol>:<subname>
 * 　jdbc->プロトコル。JDBC URLのプロトコルは常にjdbcとなる
 * 　<subprotocol>->データベースに接続するための、ドライバ独自のプロトコル名。ドライバごとに異なる。
 * 　<subname>->データベースを特定するための情報。ホスト名やポート番号、データベース名など、subprotocolに準じて異なる。
 */
public class Sample11_01 {

	public static void main(String[]args){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// データベースの指定
			String url = "jdbc:mysql://localhost:3306/golddb";
			// データベースとの接続 - 接続できなかったらSQLException例外がスローされる。
			// JDBC4.0より前は、ドライバクラスのロードが必要だった。
//			try{
//				Class.forName("com.mysql.jdbc.Driver"); // 引数にドライバクラスのクラス名を指定する。
//			}catch (ClassNotFoundException e){
//				e.printStackTrace();
//			}
			con = DriverManager.getConnection(url, "root", "");
//			con = DriverManager.getConnection(url); // ユーザー名とpassが不要な場合はこっち
			// ステートメントの取得
			stmt = con.createStatement();
			// SQL文の実行
			String sql = "select dept_code, dept_name from department";
			rs = stmt.executeQuery(sql);
			// 結果の取得と処理
			while(rs.next()){ // next()実行前は、カーソルは先頭行の前に置かれていることに注意。必ず１回はnextしなければSQLExceptionが発生する。
				System.out.println(String.format("dept_code:%d", rs.getInt(1)));
				System.out.println(String.format("dept_name:%s", rs.getString(2)));
				/** その他のgetter
				 * データベースの型に依存することに注意。
				・char、varChar->getString
				・number->rs.getBigDecimal(1);
				・double->rs.getDouble(1);
				・date->rs.getDate(1);
				・time->rs.getTime(1);
				・timeStamp->rs.getTimestamp(1);
				*/
				// 以下はgetObjectを使用した例
				Object dept_code = rs.getObject("dept_code"); // 列番号の指定でも問題ない。
				Object dept_name = rs.getObject("dept_name");
				if(dept_code instanceof Integer){
					Integer i_dept_code = (Integer)dept_code;
					System.out.println(String.format("getObject:dept_code->[%d]", i_dept_code));
				}
				if(dept_name instanceof String){
					String i_dept_name = (String)dept_name;
					System.out.println(String.format("getObject:dept_name->[%s]", i_dept_name));
				}
				
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			// 接続のクローズ
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
