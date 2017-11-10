package book;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LendRegisterServlet")
public class LendRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LendRegisterServlet() {
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

		// ③-1-1 ログイン画面で入力された情報を取得

		String date = request.getParameter("date");
		String id = ((login.LoginUserBean) request.getSession().getAttribute("user")).getId();
		System.out.println(id);
		ItemBean bean = new ItemBean();
		bean = ((ItemBean) session.getAttribute("info"));
		String pid = bean.getPid();

		String name = ((login.LoginUserBean) session.getAttribute("user")).getName();

		// ③-1-3 ログイン処理クラスをインスタンス化

		LendRegisterDao dao = new LendRegisterDao();
		// ③-1-4 ID処理クラスに②-1-1で取得したIDを渡してユーザ情報をモデルに格納

		int rs = 0;
		try {
			rs = dao.registerLend(pid, name, date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rs == 1) {
			rd = request.getRequestDispatcher("/bookRegisterOK.jsp");
			rd.forward(request, response);

		} else {
			rd = request.getRequestDispatcher("/registerNG.jsp");
			rd.forward(request, response);

		}
	}
}
