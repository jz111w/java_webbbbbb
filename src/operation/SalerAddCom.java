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
 * Servlet implementation class SalerAddCom
 */
@WebServlet("/SalerAddCom")
public class SalerAddCom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalerAddCom() {
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
		servletContext.setAttribute("idsaler", idsaler);
		String salerid = request.getParameter("salerid");
		String salername = request.getParameter("salername");
		String salerprice = request.getParameter("salerprice");
		String salerstock = request.getParameter("salerstock");

		double price = Double.parseDouble(salerprice);
		if (price <= 0) {
			response.sendRedirect("SalerAddFa.html");
		}
		int stock = (int) (Double.parseDouble(salerstock));
		if (stock <= 0) {
			response.sendRedirect("SalerAddFa.html");
		}
		salerstock = String.valueOf(stock);
		Com com = new Com(salerid, salerbrand, salername, salerprice, salerstock);
		int count = ComDao.insert(com);
		if (count > 0) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String time = formatter.format(date);
			String ip = request.getRemoteAddr();
			String action = "add";
			SalerLogO salerLogO = new SalerLogO(ClassRandom.getRandomString(10), idsaler, time, ip, action);
			SalerLogODao.insert(salerLogO);
			response.sendRedirect("SalerAddSuc.html");
		} else {
			response.sendRedirect("SalerAddFa.html");
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
