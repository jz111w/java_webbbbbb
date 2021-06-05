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

import dao.SalerDao;
import dao.SalerLogODao;
import entity.Saler;
import entity.SalerLogO;

/**
 * Servlet implementation class SalerChangePWOne
 */
@WebServlet("/SalerChangePw")
public class SalerChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalerChangePw() {
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
		String idsaler = (String) servletContext.getAttribute("idsaler");
		servletContext.setAttribute("idsaler", idsaler);

		String pw = request.getParameter("pw");
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");

		if (!pw1.equals(pw2)) {
			request.getRequestDispatcher("SalerChangePwWrong.jsp").forward(request, response);
		}
		Saler saler = SalerDao.selectById(idsaler);
		String pw3 = saler.getPw();
		Boolean a = pw.equals(pw3);
		if (!a) {
			request.getRequestDispatcher("SalerChangePwWrong.jsp").forward(request, response);
		}
		int count = SalerDao.updatePw(idsaler, pw1);
		if (count > 0) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String time = formatter.format(date);
			String ip = request.getRemoteAddr();
			String action = "changepw";
			SalerLogO salerLogO = new SalerLogO(ClassRandom.getRandomString(10), idsaler, time, ip, action);
			SalerLogODao.insert(salerLogO);
			request.getRequestDispatcher("SalerHome.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("SalerChangePwWrong.jsp").forward(request, response);
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
