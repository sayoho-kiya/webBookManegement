package book;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Lending {

	public ArrayList<ItemBean> getBookInfomation() {

		ArrayList<ItemBean> beanList = new ArrayList<>();
		LendingDao dao = null;

		ResultSet rs = null;
		try {
			//DAOクラスをインスタンス化
			dao = new LendingDao();
			//DB検索を実行
			rs = dao.getBookList();

			while(rs.next()) {
				ItemBean bean = new ItemBean();

				//評価を四捨五入⇒★での表示に変更する
				Double evaluation = rs.getDouble("AVE_EVA");
				BigDecimal ava = new BigDecimal(evaluation);
				ava = ava.setScale(1, BigDecimal.ROUND_HALF_UP);

				String evalprint = "";
				if(evaluation == 0) {
				} else if(evaluation < 1.5) {
					evalprint = ava + "　★";
				} else if(evaluation <= 2.5) {
					evalprint = ava + "　★★";
				} else if(evaluation <= 3.5) {
					evalprint = ava + "　★★★";
				} else if(evaluation <= 4.5) {
					evalprint = ava + "　★★★★";
				} else if(evaluation <= 5) {
					evalprint = ava + "　★★★★★";
				}

				bean.setPid(rs.getString("PID"));
				bean.setTitle(rs.getString("TITLE"));
				bean.setPublisher(rs.getString("PUBLISHER"));
				bean.setAuthor(rs.getString("AUTHOR"));
				bean.setGenre(rs.getString("GENRE"));
				bean.setEval(evalprint);
				bean.setArea(rs.getString("AREA"));
				bean.setPrice(rs.getString("PRICE"));
				bean.setState(rs.getInt("STATE"));

				beanList.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//処理終了時に各接続を解除
			dao.close();
		}
		return beanList;

	}

}
