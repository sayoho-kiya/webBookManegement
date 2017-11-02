package login;
//ログイン処理
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {
	public LoginUserBean getUserData(String id, String pass) {
		LoginUserBean bean = null;
		LoginDao dao = null;
		ResultSet rs = null;
		try {
			//DAOクラスをインスタンス化
			dao = new LoginDao();
			//画面で入力されたIDとパスワードをもとにDB検索を実行
			rs = dao.selectUser(id, pass);
			while(rs.next()) {
				//検索結果が存在する場合はbeanに値をセット
				//（結果が1件しか返らないことを想定）
				bean = new LoginUserBean();
				//ID(IDは引数のものをセット）
				bean.setId(id);
				//名前
				bean.setName(rs.getString("name"));
				//年齢
				bean.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//処理終了時に各接続を解除
			dao.close();
		}
		return bean;

	}

}
