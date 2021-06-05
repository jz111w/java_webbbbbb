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
import dao.LogBDao;
import dao.UserdataDao;
import entity.Com;
import entity.LogB;
import entity.Userdata;

/**
 * Servlet implementation class ComDet
 */
@WebServlet("/ComDet")
public class ComDet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComDet() {
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
		String id = request.getParameter("id");

		Com com = ComDao.selectByid(id);
		ServletContext servletContext = request.getServletContext();
		String email = (String) servletContext.getAttribute("email");

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String time = formatter.format(date);

		LogB logB = new LogB(ClassRandom.getRandomString(10), time, email, com.getId(), com.getBrand(), com.getName());

		LogBDao.insert(logB);
		servletContext.setAttribute("com", com);

		if (!email.equals("")) {
			if (UserdataDao.selectByEB(email, com.getBrand()) != null) {
				Userdata ud = UserdataDao.selectByEB(email, com.getBrand());
				UserdataDao.update(ud.getId(), ud.getGrade() + 1);
			} else {
				Userdata ud = new Userdata(ClassRandom.getRandomString(10), email, com.getBrand(), 1);
				UserdataDao.insert(ud);
			}
		}

		response.sendRedirect("Detail.jsp");
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
