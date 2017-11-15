package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps = null;
	private static String url = "jdbc:mysql://localhost/bookmgr?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String pw = "1981";

	//データベースから指定されたIDとパスワードを使ってユーザ情報を検索
	public ResultSet selectUser(String id, String pass) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成
			ps = con.prepareStatement("select name,addres from user where id=? and pass=?;");
			ps.setString(1, id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
		} catch (ClassNotFoundException ce) {
			//JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}
		return rs;
	}

	//履歴を取得
	public ResultSet selectHistory(String name) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成
			ps = con.prepareStatement("select title,publisher,author,genre,evaluation,out_date,in_date,"
					+ "sche_date,impressions from book_list inner join lend_list on lend_list.pid=book_list.pid where name='" + name + "';");
			rs = ps.executeQuery();
		} catch (ClassNotFoundException ce) {
			//JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}
		return rs;
	}

	//ログインユーザーに貸出中の本を取得
	public ResultSet getLendtitle(String name) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成
			ps = con.prepareStatement("select title from lend_list inner join book_list on "
					+ "lend_list.pid=book_list.pid where name='" + name + "'and in_date is null;");
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