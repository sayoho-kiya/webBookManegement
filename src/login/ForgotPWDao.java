package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ForgotPWDao {

	private Connection con;
	private ResultSet rs;
	private Statement st;
	private static String url = "jdbc:mysql://localhost/bookmgr?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String pw = "1981";

	//データベースに登録
	public ResultSet registerUser(String name, String mailaddres) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成
			String sql = "select id,pass from user where name='" + name + "' and addres='" + mailaddres + "';";
			st = con.createStatement();
			rs = st.executeQuery(sql);
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

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}