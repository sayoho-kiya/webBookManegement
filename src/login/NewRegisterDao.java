package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewRegisterDao {

	private Connection con;
	private int rs;
	private PreparedStatement ps = null;
	private static String url = "jdbc:mysql://localhost/bookmgr?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String pw = "1981";

	//データベースに登録
	public int registerUser(String ID, String name, String mailaddres, String pass) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成
			String sql = "insert into user values(?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, mailaddres);

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