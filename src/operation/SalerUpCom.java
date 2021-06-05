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

import dao.ComDao;
import dao.SalerLogODao;
import entity.Com;
import entity.SalerLogO;

/**
 * Servlet implementation class SalerUpCom
 */
@WebServlet("/SalerUpCom")
public class SalerUpCom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalerUpCom() {
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
		String salerbrand = (String) servletContext.getAttribute("salerbrand");
		String idsaler = (String) servletContext.getAttribute("idsaler");
		String comid = (String) servletContext.getAttribute("comid");
		String salername = request.getParameter("salername");
		String salerprice = request.getParameter("salerprice");
		String salerstock = request.getParameter("salerstock");
		servletContext.setAttribute("idsaler", idsaler);

		double price = Double.parseDouble(salerprice);
		if (price <= 0) {
			response.sendRedirect("SalerUpFa.html");
		}
		int stock = (int) (Double.parseDouble(salerstock));
		if (stock <= 0) {
			response.sendRedirect("SalerUpFa.html");
		}
		salerstock = String.valueOf(stock);
		Com com = new Com(comid, salerbrand, salername, salerprice, salerstock);
		int count = ComDao.update(com);
		System.out.println(com.toString());
		if (count > 0) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String time = formatter.format(date);
			String ip = request.getRemoteAddr();
			String action = "up";
			SalerLogO salerLogO = new SalerLogO(ClassRandom.getRandomString(10), idsaler, time, ip, action);
			SalerLogODao.insert(salerLogO);
			response.sendRedirect("SalerCom.jsp");
		} else {
			response.sendRedirect("SalerUpFa.html");
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
