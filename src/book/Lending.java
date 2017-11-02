package book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lending {
	public ItemBean getBookInfomation() {
		LendingDao dao = null;
		ItemBean bean = null;
		ResultSet rs = null;
		List<String[]> infomation = new ArrayList<>();
		try {
			//DAOクラスをインスタンス化
			dao = new LendingDao();
			//DB検索を実行
			rs = dao.getBookList();

			while(rs.next()) {
				bean = new ItemBean();

				bean.setPid(rs.getString("PID"));
				bean.setTitle(rs.getString("TITLE"));
			}

			//	public List<String[]> getBookInfomation() {
			//
			//		LendingDao dao = null;
			//		ResultSet rs = null;
			//		List<String[]> infomation = new ArrayList<>();
			//		try {
			//			//DAOクラスをインスタンス化
			//			dao = new LendingDao();
			//			//DB検索を実行
			//			rs = dao.getBookList();
			//
			//			while(rs.next()) {
			//				String[] bookinfo = new String[8];
			//				//評価を四捨五入⇒★での表示に変更する
			//				Double evaluation = rs.getDouble("AVE_EVA");
			//				BigDecimal ava = new BigDecimal(evaluation);
			//				ava = ava.setScale(1, BigDecimal.ROUND_HALF_UP);
			//
			//				String evalprint = "";
			//				if(evaluation == 0) {
			//				} else if(evaluation < 1.5) {
			//					evalprint = ava + "　★";
			//				} else if(evaluation <= 2.5) {
			//					evalprint = ava + "　★★";
			//				} else if(evaluation <= 3.5) {
			//					evalprint = ava + "　★★★";
			//				} else if(evaluation <= 4.5) {
			//					evalprint = ava + "　★★★★";
			//				} else if(evaluation <= 5) {
			//					evalprint = ava + "　★★★★★";
			//				}
			//
			//				bookinfo[0] = rs.getString("PID");
			//				bookinfo[1] = rs.getString("TITLE");
			//				bookinfo[2] = rs.getString("PUBLISHER");
			//				bookinfo[3] = rs.getString("AUTHOR");
			//				bookinfo[4] = rs.getString("GENRE");
			//				bookinfo[5] = evalprint;
			//				bookinfo[6] = rs.getString("AREA");
			//				//通貨形式に変更
			//				NumberFormat nfCur = NumberFormat.getCurrencyInstance(Locale.JAPAN);
			//				bookinfo[7] = nfCur.format(rs.getInt("PRICE"));
			//				infomation.add(bookinfo);
			//
			//			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//処理終了時に各接続を解除
			dao.close();
		}
		return bean;
		//return infomation;

	}

}
