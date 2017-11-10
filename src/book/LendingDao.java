package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LendingDao {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps = null;
	private static String url = "jdbc:mysql://localhost/bookmgr?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String pw = "1981";

	//データベースからBook_list取得
	public ResultSet getBookList() throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成
			ps = con.prepareStatement("select*from book_list;");
			rs = ps.executeQuery();
		} catch (ClassNotFoundException ce) {
			//JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}
		return rs;
	}

	//データベースから貸出者を取得
	public ResultSet getLendname(String pid) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成
			ps = con.prepareStatement("SELECT LEND_LIST.NAME,LEND_LIST.NUM,BOOK_LIST.STATE, LEND_LIST.SCHE_DATE"
					+ " FROM LEND_LIST INNER JOIN BOOK_LIST ON LEND_LIST.PID=BOOK_LIST.PID "
					+ "WHERE BOOK_LIST.STATE='1' and LEND_LIST.in_DATE is null  and lend_list.out_date <= date(now())  and LEND_LIST.PID=" + pid + ";");
			rs = ps.executeQuery();
		} catch (ClassNotFoundException ce) {
			//JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}

		return rs;
	}

	public void close() {
		try {
			con.close();
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}