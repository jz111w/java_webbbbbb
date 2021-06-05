package operation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagerLogODao;
import dao.UserDao;
import entity.ManagerLogO;
import entity.User;

/**
 * Servlet implementation class ManagerLogin
 */
@WebServlet("/ManagerLogin")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerLogin() {
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

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		User user = null;
		user = UserDao.selectByEmail(email);
		// System.out.print(user.toString());

		if (user == null) {
			response.sendRedirect("LoFailed.html");
			return;
		}

		String pw2 = user.getPw();
		if (pw2.equals(pw) && user.getType().equals("3")) {
			ServletContext servletContext = request.getServletContext();
			servletContext.setAttribute("email", email);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String time = formatter.format(date);
			String ip = request.getRemoteAddr();
			String action = "in";
			ManagerLogO mlo = new ManagerLogO(ClassRandom.getRandomString(10), time, ip, action);
			ManagerLogODao.insert(mlo);
			response.sendRedirect("ManagerHome.jsp");
		} else {
			response.sendRedirect("ManagerLoFailed.html");
		}
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
