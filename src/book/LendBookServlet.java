package book;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LendBookServlet
 */
@WebServlet("/LendBookServlet")
public class LendBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LendBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

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

		HttpSession session = request.getSession(false);
		System.out.println("セッションなしのため作成2");
		if(session == null) {
			session = request.getSession();
			String userbean = (String) session.getAttribute("user");
			request.setAttribute("user", userbean);
		}

		RequestDispatcher rd;

		Enumeration<String> names = request.getParameterNames();

		String title = "";
		// 現在のパラメータ名

		// ボタンがクリックされた場所を特定
		// クリックされたボタンの値（value）が取得できる

		// 渡ってきたパラメータを順番に処理
		// パラメータ名を取得
		while(names.hasMoreElements()) {
			title = names.nextElement();

			if("貸出".equals(request.getParameter(title)) || "返却".equals(request.getParameter(title))) {
				String[] name = request.getParameterValues(title);
				ItemBean bean = new ItemBean();
				bean.setTitle(name[1]);
				bean.setPublisher(name[2]);
				bean.setAuthor(name[3]);
				bean.setPid(name[4]);

				if("貸出".equals(request.getParameter(title))) {
					session.setAttribute("info", bean);
					rd = request.getRequestDispatcher("/LendBookConfirm.jsp");
					rd.forward(request, response);
				} else if("返却".equals(request.getParameter(title))) {
					ItemBean rtnbean = new ItemBean();
					rtnbean.setTitle(name[1]);
					rtnbean.setPublisher(name[2]);
					rtnbean.setAuthor(name[3]);
					rtnbean.setPid(name[4]);

					session.setAttribute("rtninfo", rtnbean);
					rd = request.getRequestDispatcher("/returnBookConfirm.jsp");
					rd.forward(request, response);

				}
			}
		}

	}
}
