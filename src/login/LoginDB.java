package login;
//ログイン処理
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import book.HistoryBean;

public class LoginDB {
	public LoginUserBean getUserData(String id, String pass) {
		LoginUserBean userbean = null;
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
				userbean = new LoginUserBean();
				//ID(IDは引数のものをセット）
				userbean.setId(id);
				//名前
				userbean.setName(rs.getString("name"));
				//アドレス
				userbean.setAddres(rs.getString("addres"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//処理終了時に各接続を解除
			dao.close();
		}
		return userbean;

	}

	public ArrayList<HistoryBean> getHistory(String name) {
		HistoryBean historybean = null;
		LoginDao dao = null;
		ResultSet rs = null;
		ArrayList<HistoryBean> beanList = new ArrayList<>();

		try {
			//DAOクラスをインスタンス化
			dao = new LoginDao();
			//画面で入力されたIDとパスワードをもとにDB検索を実行
			rs = dao.selectHistory(name);
			while(rs.next()) {
				historybean = new HistoryBean();
				//検索結果が存在する場合はbeanに値をセット
				historybean.setTitle(rs.getString("title"));
				historybean.setPublisher(rs.getString("publisher"));
				historybean.setAuthor(rs.getString("author"));
				historybean.setGenre(rs.getString("genre"));
				historybean.setEvaluation(rs.getInt("evaluation"));
				historybean.setOutdate(rs.getString("out_date"));
				historybean.setIndate(rs.getString("in_date"));
				historybean.setSchedate(rs.getString("sche_date"));
				historybean.setImpressions(rs.getString("impressions"));

				beanList.add(historybean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//処理終了時に各接続を解除
			dao.close();
		}
		return beanList;

	}

	//ログインユーザに貸出中の本を取得
	public String getLendTitle(String name) {
		String title = "";
		LoginDao dao = null;
		ResultSet rs = null;
		try {
			//DAOクラスをインスタンス化
			dao = new LoginDao();
			//画面で入力されたIDとパスワードをもとにDB検索を実行
			rs = dao.getLendtitle(name);
			while(rs.next()) {
				//検索結果が存在する場合はbeanに値をセット
				//（結果が1件しか返らないことを想定）
				title = rs.getString("title");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//処理終了時に各接続を解除
			dao.close();
		}
		return title;

	}

}
