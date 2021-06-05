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
 * Servlet implementation class SalerAddStockTwo
 */
@WebServlet("/SalerAddStockTwo")
public class SalerAddStockTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalerAddStockTwo() {
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

		String num = request.getParameter("num");
		ServletContext servletContext = request.getServletContext();
		String stockid = (String) servletContext.getAttribute("stockid");
		String idsaler = (String) servletContext.getAttribute("idsaler");
		servletContext.setAttribute("idsaler", idsaler);
		int add = Integer.parseInt(num);

		Com com = ComDao.selectByid(stockid);
		String oldstock = com.getStock();
		int old = Integer.parseInt(oldstock);
		int news = old + add;
		String newstock = String.valueOf(news);
		com.setStock(newstock);
		ComDao.update(com);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String time = formatter.format(date);
		String ip = request.getRemoteAddr();
		String action = "purchase";
		SalerLogO salerLogO = new SalerLogO(ClassRandom.getRandomString(10), idsaler, time, ip, action);
		SalerLogODao.insert(salerLogO);
		response.sendRedirect("SalerMonitor.jsp");
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
