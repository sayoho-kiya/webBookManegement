package book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LendRegisterDao {

	private Connection con;
	private int rs;
	private PreparedStatement ps = null;
	private static String url = "jdbc:mysql://localhost/bookmgr?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String pw = "1981";

	//本日の日付取得
	private static Date today = new Date(); //java.util.Date型
	private static SimpleDateFormat DataFmt = new SimpleDateFormat("yyyy-MM-dd");
	private static String Today = DataFmt.format(today);

	//データベースに登録
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