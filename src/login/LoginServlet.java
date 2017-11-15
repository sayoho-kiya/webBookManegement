package login;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import book.HistoryBean;

//ログイン、ログアウト処理を受け付け

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("submit");
		//セッションオブジェクトの生成
		HttpSession session = request.getSession(false);
		if(session == null) {
			session = request.getSession(true);
		}
		RequestDispatcher rd;
		if("h".equals(btn)) {

			String name = ((LoginUserBean) session.getAttribute("user")).getName();

			//履歴を取得
			LoginDB login = new LoginDB();
			ArrayList<HistoryBean> historyList = login.getHistory(name);

			// リクエストスコープにセットして画面移動

			request.setAttribute("historyList", historyList);
			rd = request.getRequestDispatcher("/history.jsp");
			rd.forward(request, response);

		}
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("submit");
		//セッションオブジェクトの生成
		HttpSession session = request.getSession(false);
		if(session == null) {
			session = request.getSession(true);
		}

		RequestDispatcher rd;

		if("ログイン".equals(btn)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");

			LoginDB login = new LoginDB();
			LoginUserBean userbean = login.getUserData(id, pass);

			if(pass.equals("0")) {
				rd = request.getRequestDispatcher("/RegisterServlet");
				rd.forward(request, response);
			} else if(userbean != null) {
				String name = userbean.getName();

				ArrayList<HistoryBean> historyList = login.getHistory(name);

				//名前を"user"、値をuserbeanとして登録
				session.setAttribute("user", userbean);
				session.setAttribute("historyList", historyList);

				String session_id = session.getId();
				System.out.println(session_id);
				session.setAttribute("login_db", "login");

				//ログインユーザに貸出中の本を取得
				String lendingTitle = login.getLendTitle(name);
				request.setAttribute("lendingTitle", lendingTitle);

				rd = request.getRequestDispatcher("/LendingServlet");

				rd.forward(request, response);

			} else {

				rd = request.getRequestDispatcher("/loginNG.jsp");
				rd.forward(request, response);
			}

		} else if("h".equals(btn)) {

			String name = ((LoginUserBean) session.getAttribute("user")).getName();

			//履歴を取得
			LoginDB login = new LoginDB();
			ArrayList<HistoryBean> historyList = login.getHistory(name);

			// リクエストスコープにセットして画面移動
			request.setAttribute("history", historyList);
			rd = request.getRequestDispatcher("/history.jsp");
			rd.forward(request, response);

		}
	}
}
