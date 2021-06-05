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
 * Servlet implementation class SalerLogin
 */
@WebServlet("/SalerLogin")
public class SalerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalerLogin() {
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

		String idsaler = request.getParameter("idsaler");
		String pwsaler = request.getParameter("pwsaler");

		Saler saler = SalerDao.selectById(idsaler);
		if (saler == null) {
			response.sendRedirect("SalerLoFailed.html");
			return;
		}
		String pwString = saler.getPw();
		if (pwsaler.equals(pwString)) {
			ServletContext servletContext = request.getServletContext();
			servletContext.setAttribute("idsaler", idsaler);
			servletContext.setAttribute("charge", saler.getCharge());
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String time = formatter.format(date);
			String ip = request.getRemoteAddr();
			String action = "in";
			SalerLogO salerLogO = new SalerLogO(ClassRandom.getRandomString(10), idsaler, time, ip, action);
			SalerLogODao.insert(salerLogO);

			response.sendRedirect("SalerHome.jsp");
		} else {
			response.sendRedirect("SalerLoFailed.html");
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
