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

		// ③-1-1 ログイン画面で入力されたIDとパスワードを取得

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// ③-1-3 ログイン処理クラスをインスタンス化

		LoginDB login = new LoginDB();
		// ③-1-4 ID処理クラスに②-1-1で取得したIDを渡してユーザ情報をモデルに格納

		LoginUserBean bean = login.getUserData(id, pass);
		if(bean != null) {

			// ③-2-1 モデルの情報が存在する場合はsetAttributeメソッドを使ってセッションに情報をセット

			// モデル（ユーザ情報）
			session.setAttribute("user", bean);

			// ログイン状態

			//session.setAttribute("login_db", "login");

			// ③-2-2 つぎに表示させる画面（ビュー）を指定

			rd = request.getRequestDispatcher("/bookList.jsp");
			rd.forward(request, response);
		} else {

			// ③-3 モデルの情報が存在しない（IDに紐づくユーザ情報がない）場合

			// ③-3-1 つぎに表示させる画面（ビュー）を指定

			rd = request.getRequestDispatcher("/loginNG.jsp");
			rd.forward(request, response);
		}

	}

}
