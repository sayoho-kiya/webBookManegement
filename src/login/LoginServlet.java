package login;

import java.io.IOException;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("submit");

		//セッションオブジェクトの生成
		HttpSession session = request.getSession();

		RequestDispatcher rd;

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		LoginDB login = new LoginDB();
		LoginUserBean userbean = login.getUserData(id, pass);

		if(pass.equals("0")) {
			rd = request.getRequestDispatcher("/RegisterServlet");
			rd.forward(request, response);
		} else if(userbean != null) {

			//名前を"user"、値をbeanとして登録
			session.setAttribute("user", userbean);

			session.setAttribute("login_db", "login");

			rd = request.getRequestDispatcher("/LendingServlet");

			rd.forward(request, response);

		} else {

			rd = request.getRequestDispatcher("/loginNG.jsp");
			rd.forward(request, response);
		}

	}

}
