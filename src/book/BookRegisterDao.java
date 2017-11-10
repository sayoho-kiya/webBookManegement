package book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRegisterDao {

	private Connection con;
	private int rs;
	private PreparedStatement ps = null;
	private static String url = "jdbc:mysql://localhost/bookmgr?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String pw = "1981";

	//データベースに登録
	public int registerBook(String title, String publisher, String author, String genre, String area, int price) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成

			String sql = "INSERT INTO BOOK_LIST(TITLE,PUBLISHER,AUTHOR,GENRE,PRICE,STATE,AVE_EVA,AREA) "
					+ "VALUES(?,?,?,?,?,?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, publisher);
			ps.setString(3, author);
			ps.setString(4, genre);
			ps.setInt(5, price);
			ps.setInt(6, 0);
			ps.setDouble(7, 0);
			ps.setString(8, area);

			rs = ps.executeUpdate();

		} catch (ClassNotFoundException ce) {
			//JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}
		return rs;
	}

	public int updateBook(String pid, String title, String publisher, String author, String genre, String area, int price) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);

			//SQL文を作成

			String sql = "UPDATE BOOK_LIST SET TITLE=?, PUBLISHER=?, AUTHOR=?, GENRE=?, PRICE='?', AREA='?' WHERE PID='?';";

			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, publisher);
			ps.setString(3, author);
			ps.setString(4, genre);
			ps.setInt(5, price);
			ps.setInt(6, 0);
			ps.setDouble(7, 0);
			ps.setString(8, area);
			ps.setString(9, pid);

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