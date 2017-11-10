package login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
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
@WebServlet("/NewRegisterServlet")
public class NewRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewRegisterServlet() {
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
		String pass = request.getParameter("pass");

		//IDを付与
		Random rnd = new Random();
		int ran = 0;
		int num = 0;

		String[] pw = new String[5];
		for(int i = 0; i < 2; i++) {
			ran = rnd.nextInt(26);
			int a = 65 + ran;
			char c = (char) a;
			pw[i] = String.valueOf(c);
		}
		for(int i = 2; i < 5; i++) {
			num = rnd.nextInt(10);
			pw[i] = String.valueOf(num);
		}
		String ID = pw[0] + pw[1] + pw[2] + pw[3] + pw[4];

		// ③-1-3 ログイン処理クラスをインスタンス化

		NewRegisterDao dao = new NewRegisterDao();
		// ③-1-4 ID処理クラスに②-1-1で取得したIDを渡してユーザ情報をモデルに格納

		int rs = 0;
		try {
			rs = dao.registerUser(ID, name, mailaddres, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rs == 1) {
			request.setAttribute("ID", ID);
			rd = request.getRequestDispatcher("/registerOK.jsp");
			rd.forward(request, response);

		} else {
			rd = request.getRequestDispatcher("/registerNG.jsp");
			rd.forward(request, response);

		}
	}
}
