package login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//ログイン、ログアウト処理を受け付け

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ForgotPWServlet")
public class ForgotPWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPWServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// ① クリックされたボタンの判定
		// ①-1 ボタン名の文字化けを防ぐために文字コードを設定してから取得

		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("submit");

		//		// ② 画面移動の準備
		HttpSession session = request.getSession();
		//		// セッション
		//
		RequestDispatcher rd;
		//		// 画面の情報
		//ServletContext con = request.getServletContext();

		// ③-1-1 ログイン画面で入力された名前・アドレス・パスワードを取得

		String name = request.getParameter("name");
		String mailaddres = request.getParameter("mail");

		// ③-1-3 ログイン処理クラスをインスタンス化

		ForgotPWDao dao = new ForgotPWDao();
		// ③-1-4 ID処理クラスに②-1-1で取得したIDを渡してユーザ情報をモデルに格納

		ResultSet rs;
		try {
			rs = dao.registerUser(name, mailaddres);

			if(rs.next()) {
				String ID = rs.getString("ID");
				String password = rs.getString("pass");

				request.setAttribute("ID", ID);
				request.setAttribute("password", password);

				rd = request.getRequestDispatcher("/showData.jsp");
				rd.forward(request, response);

			} else {
				rd = request.getRequestDispatcher("/registerNG.jsp");
				rd.forward(request, response);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
