package operation;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class ChangePw
 */
@WebServlet("/ChangePw")
public class ChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePw() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		ServletContext servletContext = request.getServletContext();
		String email = (String) servletContext.getAttribute("email");
		String pw = request.getParameter("pw");
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");

		if (!pw1.equals(pw2)) {
			request.getRequestDispatcher("PwWrong.jsp").forward(request, response);
		}
		User user = UserDao.selectByEmail(email);
		String pw3 = user.getPw();
		Boolean a = pw.equals(pw3);
		if (!a) {
			request.getRequestDispatcher("PwWrong.jsp").forward(request, response);
		}
		int count = UserDao.updatePw(email, pw1);
		if (count > 0) {
			request.getRequestDispatcher("ChangePwDone.jsp").forward(request, response);
		}
		request.getRequestDispatcher("PwWrong.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
