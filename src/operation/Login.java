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

import dao.LogLDao;
import dao.UserDao;
import entity.LogL;
import entity.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		String tmp = "";
		if (email.equals(tmp)) {
			tmp = "tourist";
		} else {
			tmp = email;
		}
		user = UserDao.selectByEmail(email);
		// System.out.print(user.toString());

		if (user == null) {
			response.sendRedirect("LoFailed.html");
			return;
		}

		String pw2 = user.getPw();
		if (pw2.equals(pw) && (user.getType().equals("1") || user.getType().equals("2"))) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String time = formatter.format(date);
			String ip = request.getRemoteAddr();
			String action = "in";
			LogL logL = new LogL(ClassRandom.getRandomString(10), tmp, time, ip, action);
			LogLDao.insert(logL);
			ServletContext servletContext = request.getServletContext();
			servletContext.setAttribute("email", email);
			response.sendRedirect("Home.jsp");
		} else {
			response.sendRedirect("LoFailed.html");
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
