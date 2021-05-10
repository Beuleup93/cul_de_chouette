package uppa.m1bigdata.devweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uppa.m1bigdata.devweb.dao.DAO;
import uppa.m1bigdata.devweb.dao.DAOException;
import uppa.m1bigdata.devweb.dao.JoueurDaoImpl;
import uppa.m1bigdata.devweb.pojo.Joueur;


/**
 * Servlet implementation class JoueurServlet
 */
@WebServlet(name = "JoueurServlet", urlPatterns = {"/"})
public class JoueurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DAO<Joueur> joueurDaoImpl;

	public JoueurServlet() {
		joueurDaoImpl = new JoueurDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if (action.equals("listeJoueur")){
				request.setAttribute("joueurs", joueurDaoImpl.getAll());
				request.getRequestDispatcher("/WEB-INF/jsp/listeJoueur.jsp").forward(request,response);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
