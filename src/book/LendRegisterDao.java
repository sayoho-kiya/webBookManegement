package book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LendRegisterDao {

	private Connection con;
	private Statement st;
	private int rs;
	private PreparedStatement ps = null;
	private static String url = "jdbc:mysql://localhost/bookmgr?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String pw = "1981";

	//本日の日付取得
	private static Date today = new Date(); //java.util.Date型
	private static SimpleDateFormat DataFmt = new SimpleDateFormat("yyyy-MM-dd");
	private static String Today = DataFmt.format(today);

	//データベースに貸出登録
	public int registerLend(String pid, String name, String date) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成

			String sql = "INSERT INTO BOOKMGR.LEND_LIST"
					+ "(PID,NAME,OUT_DATE,SCHE_DATE,IN_DATE,EVALUATION) VALUES(?,?,?,?,?,?);";

			ps = con.prepareStatement(sql);

			ps.setString(1, pid);
			ps.setString(2, name);
			ps.setString(3, Today);
			ps.setString(4, date);
			ps.setDate(5, null);
			ps.setInt(6, 0);
			rs = ps.executeUpdate();

			String statesql = "UPDATE BOOK_LIST SET STATE='1' WHERE PID=" + pid + ";";
			st = con.createStatement();
			rs = st.executeUpdate(statesql);

		} catch (ClassNotFoundException ce) {
			//JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}
		return rs;
	}

	//データベースに返却登録
	public int registerReturn(String pid, String name, String evaluation, String impressions) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成
			String sql = "UPDATE LEND_LIST SET IN_DATE=?,evaluation=?,impressions=? where name=? and pid=? and in_date is null;";

			ps = con.prepareStatement(sql);

			ps.setString(1, Today);
			ps.setString(2, evaluation);
			ps.setString(3, impressions);
			ps.setString(4, name);
			ps.setString(5, pid);
			rs = ps.executeUpdate();

			//評価の平均値をBook_listに反映させる
			String evalsql = "SELECT AVG(evaluation) avg  FROM LEND_LIST WHERE PID='" + pid + "' and in_date is not null;";
			ps = con.prepareStatement(evalsql);

			ResultSet result = ps.executeQuery();
			int avg = 0;
			if(result.next()) {
				avg = result.getInt("avg");
			}

			//Book_list stateと評価の更新
			String statesql = "UPDATE BOOK_LIST SET STATE='0',AVE_EVA='" + avg + "' WHERE PID='" + pid + "';";
			st = con.createStatement();
			st.executeUpdate(statesql);

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

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}