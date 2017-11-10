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
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBookServlet() {
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

		HttpSession session = request.getSession();

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

			if("編集".equals(request.getParameter(title))) {
				String[] name = request.getParameterValues(title);
				ItemBean bean = new ItemBean();
				bean.setTitle(name[1]);
				bean.setPublisher(name[2]);
				bean.setAuthor(name[3]);
				bean.setGenre(name[4]);
				bean.setEval(name[5]);
				bean.setArea(name[6]);
				bean.setPrice(name[7]);
				bean.setPid(name[8]);

				session.setAttribute("registerinfo", bean);
				rd = request.getRequestDispatcher("/bookUpdate.jsp");
				rd.forward(request, response);

			}
		}
	}
	//Enumeration names = request.getParameterNames();
	//while(names.hasMoreElements()) {
	//String name[] = (String[]) names.nextElement();

	//String name = request.getParameterValues("bookinfo[]");

	//String title = request.getParameter("<%= bean.getTitle() %>");
	//if(info != null) {
	//for(int i = 0; i < info.length; i++) {
	//	bean.setTitle(name[0]);
	//	bean.setPublisher(name[1]);
	//	bean.setAuthor(name[2]);
	//	for(int i = 0; i < name.length; i++) {
	//		System.out.println(name[i]);
	//}
	//bean.setPublisher(info[1]);
	//bean.setAuthor(info[2]);
	//}

	//if(bean != null) {

	//	}

	//}

	//}

}
