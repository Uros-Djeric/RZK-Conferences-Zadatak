package servlets;

import model.Conference;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rzk.beans.session.ConfInfoSBRemote;

/**
 * Servlet implementation class CuvanjeServlet
 */
@WebServlet("/CuvanjeServlet")
public class CuvanjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;

	@EJB
	ConfInfoSBRemote confInfo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CuvanjeServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest r, HttpServletResponse response) throws ServletException, IOException {

		String city = r.getParameter("city");
		String country = r.getParameter("country");
		String field = r.getParameter("field");
		String title = r.getParameter("title");

		Date dateFrom, dateTo = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

		try {
			dateTo = sdf.parse(r.getParameter("dateTo"));
			dateFrom = sdf.parse(r.getParameter("dateFrom"));

			Conference c = new Conference();

			c.setCity(city);
			c.setCountry(country);
			c.setField(field);
			c.setTitle(title);
			c.setDateFrom(dateFrom);
			c.setDateTo(dateTo);

			// boolean ok = confInfo.addConference(c);

			boolean ok = confInfo.addConference(c);
			System.out.println("Status ok: " + ok + "!");
			String msg = "";
			if (ok)
				msg = "Conference added!";
			r.setAttribute("poruka", msg);
			r.getRequestDispatcher("index.jsp").forward(r, response);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
