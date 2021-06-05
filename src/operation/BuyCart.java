package operation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.ComDao;
import dao.LogPDao;
import dao.OrdDao;
import dao.UserdataDao;
import entity.Cart;
import entity.Com;
import entity.LogP;
import entity.Ord;
import entity.Userdata;

/**
 * Servlet implementation class BuyCart
 */
@WebServlet("/BuyCart")
public class BuyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyCart() {
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

		ArrayList<Cart> list = CartDao.selectByEmail(email);
		for (Cart i : list) {
			String comid = i.getComid();
			Com com = ComDao.selectByid(comid);
			String stock = com.getStock();
			int num = Integer.parseInt(stock);
			num = num - 1;
			if (num >= 0) {
				stock = String.valueOf(num);
				com.setStock(stock);
				ComDao.update(com);
			} else {
				response.sendRedirect("BuyErro.html");
				return;
			}
		}
		for (Cart i : list) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String time = formatter.format(date);
			Ord ord = new Ord(ClassRandom.getRandomDegitString(10), time, email, i.getComid(), i.getCombrand(),
					i.getComname(), i.getComprice());
			OrdDao.insert(ord);
			LogP logP = new LogP(ClassRandom.getRandomDegitString(10), time, email, i.getComid(), i.getCombrand(),
					i.getComname());
			LogPDao.insert(logP);
			if (!email.equals("")) {
				if (UserdataDao.selectByEB(email, i.getCombrand()) != null) {
					Userdata ud = UserdataDao.selectByEB(email, i.getCombrand());
					UserdataDao.update(ud.getId(), ud.getGrade() + 3);
				} else {
					Userdata ud = new Userdata(ClassRandom.getRandomString(10), email, i.getCombrand(), 3);
					UserdataDao.insert(ud);
				}

			}

		}
		CartDao.deleteAll(email);
		response.sendRedirect("ConfirmOrder.html");
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
